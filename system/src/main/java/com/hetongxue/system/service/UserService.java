package com.hetongxue.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hetongxue.system.domain.User;

/**
 * @Description: 用户服务
 * @InterfaceNmae: UserService
 * @Author: 何同学
 * @DateTime: 2022-06-08 16:55
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 获取角色和菜单权限代码
     */

    String getRolePermissionCode(Long userId);
}