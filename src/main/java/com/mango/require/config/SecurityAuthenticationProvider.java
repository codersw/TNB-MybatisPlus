package com.mango.require.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mango.require.enums.IsDelEnum;
import com.mango.require.model.User;
import com.mango.require.service.IRoleService;
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
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private IUserService userService;

    @Resource
    private IRoleService roleService;

    private GrantedAuthoritiesMapper grantedAuthoritiesMapper;

    public void setGrantedAuthoritiesMapper(GrantedAuthoritiesMapper grantedAuthoritiesMapper) {
        this.grantedAuthoritiesMapper = grantedAuthoritiesMapper;
    }

    /**
     * 验证Authentication，建立系统使用者信息principal(token)
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //从token中获取用户信息
        SimpleKeycloakAccount account = (SimpleKeycloakAccount) authentication.getDetails();
        Principal principal = account.getPrincipal();
        log.info(principal.getName());
        KeycloakSecurityContext context= account.getKeycloakSecurityContext();
        AccessToken accessToken = context.getToken();
        String userName = accessToken.getPreferredUsername();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, userName).eq(User::getIsDel, IsDelEnum.FALSE);
        User user = userService.getOne(queryWrapper);
        if(user == null) {
            user = User.builder()
                    .username(userName)
                    .build();
            userService.save(user);
        }
        List<GrantedAuthority> grantedAuthorities = null;
        return new KeycloakAuthenticationToken(account, accessToken.isActive(), mapAuthorities(grantedAuthorities));
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
