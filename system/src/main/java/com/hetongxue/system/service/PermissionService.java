package com.hetongxue.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hetongxue.system.domain.Permission;

import java.util.List;

/**
 * @Description: 权限服务
 * @InterfaceNmae: PermissionService
 * @Author: 何同学
 * @DateTime: 2022-06-08 16:56
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 通过用户ID获取对应角色的权限信息
     */
    List<Permission> getPermissionByUserId(Long userId);

}