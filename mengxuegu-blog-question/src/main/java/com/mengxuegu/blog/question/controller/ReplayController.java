package com.mengxuegu.blog.question.controller;


import com.mengxuegu.blog.question.service.IReplayService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 回答信息表 前端控制器
 * </p>
 *
 * @author byl
 * @since 2021-11-26
 */
@Api(value = "回答管理接口",description = "回答管理接口，提供回答的增、删、改、查")
@RestController
@RequestMapping("/replay")
public class ReplayController {

    @Autowired
     private IReplayService replayService;
      @ApiImplicitParam(name = "id",value = "回答评论ID",required = true)
      @ApiOperation("删除回答评论接口")
      @DeleteMapping("/{id}")
      public Result delete(@PathVariable("id") String id){
          return replayService.deleteById(id);
      }
}
