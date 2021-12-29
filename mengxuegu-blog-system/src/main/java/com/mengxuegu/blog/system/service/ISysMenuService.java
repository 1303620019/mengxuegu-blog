package com.mengxuegu.blog.system.service;

import com.mengxuegu.blog.entities.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.system.req.SysMenuREQ;
import com.mengxuegu.blog.util.base.Result;

import java.util.List;

/**
 * <p>
 * 菜单信息表 服务类
 * </p>
 *
 * @author byl
 * @since 2021-12-02
 */
public interface ISysMenuService extends IService<SysMenu> {

    /** 条件查询菜单列表
     * @param req
     * 条件查询
     *  @return
     **/
    Result queryList(SysMenuREQ req);
    /**
    * 功能描述: <br>
    * 〈通过菜单资源id删除权限数据〉
    * @Param: [id]
    * @Return: com.mengxuegu.blog.util.base.Result
    * @Author: byl
    * @Date:  
    */
    Result deleteById(String id);
}
