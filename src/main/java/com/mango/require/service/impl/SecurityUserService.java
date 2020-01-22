package com.mango.require.service.impl;

import com.mango.require.model.User;
import com.mango.require.model.UserDetails;
import com.mango.require.service.IMenuService;
import com.mango.require.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SecurityUserService implements UserDetailsService {

    @Resource
    private IUserService userService;

    @Resource
    private IMenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if (user == null) throw new UsernameNotFoundException(username);
        String permissions = menuService.findUserPermissions(user.getUserId());
        return new UserDetails(user.getUsername(), user.getPassword(), true, true, true, false,
                AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
    }
}
