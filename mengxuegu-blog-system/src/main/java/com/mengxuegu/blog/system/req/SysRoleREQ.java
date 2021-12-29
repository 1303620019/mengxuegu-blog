package com.mengxuegu.blog.system.req;

import com.mengxuegu.blog.entities.SysRole;
import com.mengxuegu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description:
 * @projectName:mengxuegu-blog
 * @see:com.mengxuegu.blog.system.req
 * @author:byl
 * @createTime:2021/12/7 18:24
 * @version:1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "SysRoleREQ对象",discriminator = "角色查询条件")
public class SysRoleREQ extends BaseRequest<SysRole> {
    @ApiModelProperty(value = "角色名称")
   private String name;

}
