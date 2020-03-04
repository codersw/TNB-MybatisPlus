package com.mango.require.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.require.entity.common.CurrentUser;
import com.mango.require.entity.pojo.*;
import com.mango.require.exception.RequireException;
import com.mango.require.mapper.DeptMapper;
import com.mango.require.mapper.MenuMapper;
import com.mango.require.mapper.UserMapper;
import com.mango.require.mapper.UserRoleMapper;
import com.mango.require.service.IUserService;
import com.mango.require.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final String misUrl = "https://mis.517.cn/mangoapi/UserNoLogin/GetUserName?userid=%s";

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public CurrentUser findByUserId(Integer userId) {
        User user = baseMapper.selectById(userId);
        CurrentUser currentUser;
        if(user != null) {
            currentUser = MapperUtils.mapperBean(user, CurrentUser.class);
            currentUser.setDeptName(deptMapper.selectById(currentUser.getDeptId()).getDeptName());
        } else {
            //如何空插入用户信息 默认角色2普通用户
            JSONObject json = restTemplate.getForObject(String.format(misUrl, userId), JSONObject.class);
            assert json != null;
            if(json.getInteger("flag").equals(100)) {
                JSONObject userInfo = json.getJSONObject("result");
                user = User.builder()
                        .username(userInfo.getString("UserName"))
                        .userPhoto(userInfo.getString("userphoto"))
                        .deptId(userInfo.getInteger("OrgId"))
                        .userId(userId)
                        .build();
                userMapper.insert(user);
                userRoleMapper.insert(UserRole.builder().roleId(2).userId(userId).build());
                Dept dept = deptMapper.selectById(user.getDeptId());
                if(dept == null){
                    dept = Dept.builder()
                            .deptId(user.getDeptId())
                            .deptName(userInfo.getString("OrgName"))
                            .build();
                    deptMapper.insert(dept);
                }
                currentUser = MapperUtils.mapperBean(user, CurrentUser.class);
                currentUser.setDeptName(dept.getDeptName());
            } else {
                throw new RequireException("获取用户信息失败");
            }
        }
        List<Menu> menus = menuMapper.getMenus(userId);
        currentUser.setPermissions(menus.stream().map(Menu::getPerms).collect(Collectors.joining(",")));
        return currentUser;
    }

    @Override
    public User findByUserName(String userName) {
        return this.baseMapper.findByUserName(userName);
    }

    @Override
    public void save(User user, List<Role> roles) {
        baseMapper.insert(user);
        roles.forEach(role -> this.userRoleMapper.insert(UserRole.builder()
                .roleId(role.getRoleId())
                .userId(user.getUserId())
                .build()));
    }
}
