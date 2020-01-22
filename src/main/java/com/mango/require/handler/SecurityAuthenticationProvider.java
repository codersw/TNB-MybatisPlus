package com.mango.require.handler;

import com.mango.require.model.Role;
import com.mango.require.model.User;
import com.mango.require.service.IMenuService;
import com.mango.require.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private IUserService userService;

    @Resource
    private IMenuService menuService;

    private GrantedAuthoritiesMapper grantedAuthoritiesMapper;

    public void setGrantedAuthoritiesMapper(GrantedAuthoritiesMapper grantedAuthoritiesMapper) {
        this.grantedAuthoritiesMapper = grantedAuthoritiesMapper;
    }

    /**
     * 验证Authentication，建立系统使用者信息principal(token)
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken)authentication;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //从token中获取用户信息
        SimpleKeycloakAccount account = (SimpleKeycloakAccount) authentication.getDetails();
        KeycloakSecurityContext context= account.getKeycloakSecurityContext();
        AccessToken accessToken = context.getToken();
        String userName = accessToken.getPreferredUsername();
        User user = userService.findByUserName(userName);
        //如何空插入用户信息 默认角色2普通用户
        if(user == null){
            user = User.builder()
                    .username(userName)
                    .build();
            userService.save(user, new ArrayList<Role>() {{
                add(Role.builder().roleId(2).build());
            }});
        }
        String permissions = menuService.findUserPermissions(user.getUserId());
        return new KeycloakAuthenticationToken(token.getAccount(), token.isInteractive(), mapAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(permissions)));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return KeycloakAuthenticationToken.class.isAssignableFrom(aClass);
    }

    private Collection<? extends GrantedAuthority> mapAuthorities(
            Collection<? extends GrantedAuthority> authorities) {
        return grantedAuthoritiesMapper != null
                ? grantedAuthoritiesMapper.mapAuthorities(authorities)
                : authorities;
    }
}
