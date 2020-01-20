package com.mango.require.config;

import com.mango.require.mapper.MenuMapper;
import com.mango.require.mapper.RoleMapper;
import com.mango.require.mapper.UserMapper;
import com.mango.require.mapper.UserRoleMapper;
import com.mango.require.model.Menu;
import com.mango.require.model.Role;
import com.mango.require.model.User;
import com.mango.require.model.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

@Slf4j
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

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
        User user = userMapper.findByUserName(userName);
        if(user == null){
            user = User.builder()
                    .username(userName)
                    .build();
            userMapper.insert(user);
            UserRole userRole = UserRole.builder()
                    .roleId(2)
                    .userId(user.getUserId())
                    .build();
            userRoleMapper.insert(userRole);
        }
        List<Menu> menus = menuMapper.getMenus(user.getUserId());
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        if (CollectionUtils.isNotEmpty(menus)){
            menus.forEach(p->{
                grantedAuthorities.add(new SimpleGrantedAuthority(p.getPerms()));
            });
        }
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
