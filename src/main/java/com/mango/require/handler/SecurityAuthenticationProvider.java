package com.mango.require.handler;

import com.alibaba.fastjson.JSONObject;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.pojo.Dept;
import com.mango.require.entity.pojo.Role;
import com.mango.require.entity.pojo.User;
import com.mango.require.service.IDeptService;
import com.mango.require.service.IMenuService;
import com.mango.require.service.IUserService;
import com.mango.require.utils.MapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 重写授权token赋值
 * @author swen
 */
@Slf4j
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private IUserService userService;

    @Resource
    private IDeptService deptService;

    @Resource
    private IMenuService menuService;

    @Resource
    private RestTemplate restTemplate;

    private static final String misUrl = "https://mis.517.cn/mangoapi/UserNoLogin/GetUserName?userid=%s";
    /**
     * 验证Authentication，建立系统使用者信息principal(token)
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //从token中获取用户信息
        SimpleKeycloakAccount account = (SimpleKeycloakAccount) authentication.getDetails();
        KeycloakSecurityContext context= account.getKeycloakSecurityContext();
        AccessToken accessToken = context.getToken();
        if(StringUtils.isEmpty(accessToken.getFamilyName())) {
            return null;
        }
        Integer userId = Integer.valueOf(accessToken.getFamilyName());
        CurrentUser currentUser = userService.findByUserId(userId);
        //如何空插入用户信息 默认角色2普通用户
        if(currentUser == null){
            JSONObject json = restTemplate.getForObject(String.format(misUrl, userId), JSONObject.class);
            assert json != null;
            if(json.getInteger("flag").equals(100)) {
                JSONObject userInfo = json.getJSONObject("result");
                User user = User.builder()
                        .username(userInfo.getString("UserName"))
                        .userPhoto(userInfo.getString("userphoto"))
                        .deptId(userInfo.getInteger("OrgId"))
                        .userId(userId)
                        .build();
                userService.save(user, new ArrayList<Role>() {{
                    add(Role.builder().roleId(2).build());
                }});
                Dept dept = deptService.getById(user.getDeptId());
                if(dept == null){
                   dept = Dept.builder()
                            .deptId(user.getDeptId())
                            .deptName(userInfo.getString("OrgName"))
                            .build();
                    deptService.save(dept);
                }
                currentUser = MapperUtils.mapperBean(user, CurrentUser.class);
                currentUser.setDeptName(dept.getDeptName());
            }
        }
        String permissions = menuService.findUserPermissions(userId);
        //重写token 将当前登陆人信息塞入token中
        assert currentUser != null;
        PreAuthenticatedAuthenticationToken preAuthenticatedAuthenticationToken =
                new PreAuthenticatedAuthenticationToken(currentUser, currentUser.getPassword(),
                       AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
        preAuthenticatedAuthenticationToken.setDetails(currentUser);
        return preAuthenticatedAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return KeycloakAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
