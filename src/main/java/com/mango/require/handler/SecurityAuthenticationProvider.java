package com.mango.require.handler;

import com.mango.require.entity.common.CurrentUser;
import com.mango.require.service.IDeptService;
import com.mango.require.service.IMenuService;
import com.mango.require.service.IUserService;
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

import javax.annotation.Resource;

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
        PreAuthenticatedAuthenticationToken preAuthenticatedAuthenticationToken =
                new PreAuthenticatedAuthenticationToken(currentUser, currentUser.getPassword(),
                       AuthorityUtils.commaSeparatedStringToAuthorityList(currentUser.getPermissions()));
        preAuthenticatedAuthenticationToken.setDetails(currentUser);
        return preAuthenticatedAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return KeycloakAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
