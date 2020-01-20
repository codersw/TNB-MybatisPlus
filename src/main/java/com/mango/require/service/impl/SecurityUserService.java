package com.mango.require.service.impl;

import com.mango.require.mapper.MenuMapper;
import com.mango.require.mapper.UserMapper;
import com.mango.require.model.Menu;
import com.mango.require.model.User;
import com.mango.require.model.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class SecurityUserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUserName(username);
        UserDetail userDetail = (UserDetail) user;
        if (user == null) throw new UsernameNotFoundException(username);
        List<Menu> menus = menuMapper.getMenus(user.getUserId());
        if (CollectionUtils.isNotEmpty(menus)){
            Set<SimpleGrantedAuthority> sga = new HashSet<>();
            menus.forEach(p->{
                sga.add(new SimpleGrantedAuthority(p.getPerms()));
            });
            userDetail.setAuthorities(sga);
        }
        return userDetail;
    }
}
