package com.hetongxue.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 角色实体
 * @ClassNmae: Role
 * @Author: 何同学
 * @DateTime: 2022-06-08 16:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_role")
public class Role implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String remark;
    private boolean isDelete;
    private Long createUser;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}