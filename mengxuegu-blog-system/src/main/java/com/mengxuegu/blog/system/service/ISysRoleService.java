package com.mengxuegu.blog.system.service;

import com.mengxuegu.blog.entities.SysMenu;
import com.mengxuegu.blog.entities.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.system.req.SysRoleREQ;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author byl
 * @since 2021-12-02
 */
public interface ISysRoleService extends IService<SysRole> {

/**
* 功能描述: <br>
* 〈条件分页查询角色列表〉
* @Param: [req]
* @Return: com.mengxuegu.blog.util.base.Result
* @Author: byl
* @Date:  
*/
  Result  queryPage(SysRoleREQ req);

}
