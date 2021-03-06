package com.hetongxue.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hetongxue.system.domain.Role;

import java.util.List;

/**
 * @Description: 角色服务
 * @InterfaceNmae: RoleService
 * @Author: 何同学
 * @DateTime: 2022-06-08 16:55
 */
public interface RoleService extends IService<Role> {

    /**
     * 通过用户ID获取对应角色信息
     */
    List<Role> getRoleByUserId(Long userId);

}