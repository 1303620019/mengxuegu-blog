package com.mengxuegu.blog.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengxuegu.blog.entities.SysMenu;
import com.mengxuegu.blog.system.mapper.SysMenuMapper;
import com.mengxuegu.blog.system.req.SysMenuREQ;
import com.mengxuegu.blog.system.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单信息表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2021-12-02
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Override
    public Result queryList(SysMenuREQ req) {
        QueryWrapper<SysMenu> wrapper =new QueryWrapper();
        if (StringUtils.isNotEmpty(req.getName())){
            wrapper.like("name",req.getName());
        }
        //sort 升序   update_date降序
        wrapper.orderByAsc("sort").orderByDesc("update_date");
        //获取所有的菜单
        List<SysMenu> menuList = baseMapper.selectList(wrapper);
        //封装属性结构并返回
        return Result.ok( this.buildTree(menuList) );
    }


    private List<SysMenu> buildTree(List<SysMenu> menuList){
        // 1. 获取根菜单
        List<SysMenu> rootSysMenuList=new ArrayList<>();
        for (SysMenu sysMenu:menuList) {
            // 如果 m.parentId 等于 0 就是根菜单
            if (sysMenu.getParentId().equals("0")){
                rootSysMenuList.add(sysMenu);
            }
        }
        // 2.跟菜单下的子菜单
        for(SysMenu sysMenu:rootSysMenuList){
            childrenMenu(menuList,sysMenu);
        }

            // 3. 返回根菜单，因为根菜单中封装了子菜单
            return rootSysMenuList;
    }

    /*** pid=0,id=1 系统管理》pid=1,id=2 用户管理》pid=2 增、删、改、查
     * pid=0,id=1 系统管理》pid=1,id=3 角色管理》pid=3 增、删、改、查
     *  递归获取子菜单，因为子菜单下还会有子菜单
     * @param menuList 所有菜单（包括目录、菜单、按钮）
     * */
    private SysMenu childrenMenu(List<SysMenu> menuList,SysMenu menu){
        // 封装菜单的 parentId = id 子菜单集合
        List<SysMenu> children = new ArrayList<>();
        // 每次都迭代所有菜单，判断是否为 menu 的子菜单
        for (SysMenu menu1:menuList){
            // 如果 m.parentId 等于 id 则就是它的子菜单
            if (menu1.getParentId().equals(menu.getId())){
                // 是子菜单，则递归去找这个菜单的子菜单
                children.add( childrenMenu(menuList,menu1) );
            }
        }
        // 封装 menu 的子菜单
        menu.setChildren(children);
        // 每有子菜单时返回
        return menu;
    }
    @Transactional //进行事务管理
    @Override
    public Result deleteById(String id) {
        //删除当前资源
        baseMapper.deleteById(id);
        // 删除 parent_id = id 的子资源
        LambdaQueryWrapper<SysMenu> wrapper= new LambdaQueryWrapper<SysMenu>();
        wrapper.eq(SysMenu::getParentId,id);
        baseMapper.delete(wrapper);


        return Result.ok();
    }
}
