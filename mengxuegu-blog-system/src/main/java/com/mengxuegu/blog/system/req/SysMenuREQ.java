package com.mengxuegu.blog.system.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description:
 * @projectName:mengxuegu-blog
 * @see:com.mengxuegu.blog.system.req
 * @author:byl
 * @createTime:2021/12/2 15:11
 * @version:1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "SysMenuREQ对象",description = "菜单列表查询条件")
public class SysMenuREQ {
    @ApiModelProperty(value = "菜单名称")
    private String name;
}
