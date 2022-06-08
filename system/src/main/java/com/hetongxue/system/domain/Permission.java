package com.hetongxue.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 权限实体
 * @ClassNmae: Permission
 * @Author: 何同学
 * @DateTime: 2022-06-08 16:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_permission")
public class Permission implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String name;
    private Integer type;
    private Long parentId;
    private String path;
    private String icon;
    private String component;
    private String code;
    private Long orderNum;
    private String cache;
    private boolean isDelete;
    private boolean isDisplay;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}