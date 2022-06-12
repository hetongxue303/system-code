package com.hetongxue.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hetongxue.system.domain.Permission;
import com.hetongxue.system.domain.Role;
import com.hetongxue.system.domain.User;
import com.hetongxue.system.mapper.UserMapper;
import com.hetongxue.system.service.PermissionService;
import com.hetongxue.system.service.RoleService;
import com.hetongxue.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 用户服务实现
 * @ClassNmae: UserServiceImpl
 * @Author: 何同学
 * @DateTime: 2022-06-08 16:57
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;
    private final RoleService roleService;
    private final PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("用户名或密码错误");
        // 这里获取用户角色、权限信息...
        getRolePermissionCode(user.getId());
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User getUserByUsername(String username) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public String getRolePermissionCode(Long userId) {
        String permissionCode = "";
        List<Role> roleList = roleService.getRoleByUserId(userId);
        if (roleList.size() > 0) {
            permissionCode = roleList.stream()
                    .map(item -> "ROLE_" + item.getName()).collect(Collectors.joining(",")).concat(",");
        }
        List<Permission> permissionList = permissionService.getPermissionByUserId(userId);
        if (permissionList.size() > 0) {
            permissionCode.concat(permissionList.stream()
                    .map(Permission::getCode).collect(Collectors.joining(",")));
        }
        System.out.println("code:" + permissionCode);
        return permissionCode;
    }

}