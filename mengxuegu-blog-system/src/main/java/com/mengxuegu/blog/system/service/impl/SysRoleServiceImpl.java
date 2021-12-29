package com.mengxuegu.blog.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengxuegu.blog.entities.SysMenu;
import com.mengxuegu.blog.entities.SysRole;
import com.mengxuegu.blog.system.mapper.SysRoleMapper;
import com.mengxuegu.blog.system.req.SysRoleREQ;
import com.mengxuegu.blog.system.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author byl
 * @since 2021-12-02
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
  @Override
  public Result queryPage(SysRoleREQ req) {
    QueryWrapper<SysRole> wrapper =new QueryWrapper<>();
    //条件查询
    if (StringUtils.isNotEmpty(req.getName())){
      wrapper.like("name",req.getName()); 
    }
    wrapper.orderByDesc("update_date");
    return  Result.ok(baseMapper.selectPage(req.getPage(),wrapper) );
  }
}
