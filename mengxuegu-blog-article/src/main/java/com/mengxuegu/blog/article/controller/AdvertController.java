package com.mengxuegu.blog.article.controller;


import com.mengxuegu.blog.article.req.AdvertREQ;
import com.mengxuegu.blog.article.service.IAdvertService;
import com.mengxuegu.blog.entities.Advert;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 广告信息表 前端控制器
 * </p>
 *
 * @author byl
 */
@Api(value = "广告管理接口", description = "广告管理接口,提供广告的增、删、改、查")
@RestController
@RequestMapping("/advert")
public class AdvertController {

    @Autowired
    private IAdvertService advertService;


    @ApiOperation("根据广告标题与状态查询广告分页列表接口")
    @PostMapping("/search") // /article/advert/search
    public Result search(@RequestBody AdvertREQ req) {
        return advertService.queryPage(req);
    }

    @ApiImplicitParam(name = "id", value = "广告ID", required = true)
    @ApiOperation("删除广告接口")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id) {
        return advertService.deleteById(id);
    }

    @ApiImplicitParam(name = "id", value = "广告ID", required = true)
    @ApiOperation("查询广告详情接口")
    @GetMapping("/{id}")
    public Result view(@PathVariable("id") String id) {
        return Result.ok( advertService.getById(id) );
    }

    @ApiOperation("修改广告信息接口")
    @PutMapping
    public Result update(@RequestBody Advert advert) {
        advert.setUpdateDate(new Date());
        advertService.updateById(advert);
        return Result.ok();
    }

    @ApiOperation("新增广告信息接口")
    @PostMapping
    public Result save(@RequestBody Advert advert) {
        advertService.save(advert);
        return Result.ok();
    }


}
