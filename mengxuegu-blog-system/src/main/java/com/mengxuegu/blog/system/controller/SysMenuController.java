package com.mengxuegu.blog.system.controller;


import com.mengxuegu.blog.entities.SysMenu;
import com.mengxuegu.blog.system.req.SysMenuREQ;
import com.mengxuegu.blog.system.service.ISysMenuService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单信息表 前端控制器
 * </p>
 *
 * @author byl
 * @since 2021-12-02
 */
@Api(value = "菜单管理接口",description = "菜单管理接口，提供菜单的增、删、改、查")
@RestController
@RequestMapping("/menu") // 去掉前边的sys-
public class SysMenuController {
    @Autowired
    private ISysMenuService sysMenuService;
    @ApiOperation("根据菜单名称查询列表接口")
    @PostMapping("/search")
    private Result search(@RequestBody SysMenuREQ req){
        return sysMenuService.queryList(req);
    }

    @ApiOperation(value = "通过菜单ID删除菜单接口")
    @ApiImplicitParam(value = "id",name = "菜单ID",required = true)
    @DeleteMapping("/{id}")
    private Result delete(@PathVariable("id") String id){
        return sysMenuService.deleteById(id);
    }
    @ApiOperation("新增菜单信息接口")
    @PostMapping
    private Result save(@RequestBody SysMenu sysMenu){
        sysMenuService.save(sysMenu);
        return Result.ok();
    }
    @ApiOperation("查询菜单详情接口")
    @ApiImplicitParam(value = "id",name = "菜单id",required = true)
    @GetMapping("/{id}")
    private Result view(@PathVariable("id") String id){
        return Result.ok( sysMenuService.getById(id) );
    }

    @ApiOperation("修改菜单信息接口")
    @PutMapping //请求地址 /menu
    private Result update(@RequestBody SysMenu sysMenu){
        sysMenu.setUpdateDate(new Date());
        sysMenuService.saveOrUpdate(sysMenu);
        return Result.ok();
    }




}
