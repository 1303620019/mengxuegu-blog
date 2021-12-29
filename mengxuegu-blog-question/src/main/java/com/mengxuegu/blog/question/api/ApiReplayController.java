package com.mengxuegu.blog.question.api;

import com.mengxuegu.blog.entities.Replay;
import com.mengxuegu.blog.question.service.IReplayService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @projectName:mengxuegu-blog
 * @see:com.mengxuegu.blog.question.api
 * @author:byl
 * @createTime:2021/11/29 17:03
 * @version:1.0
 */
@Api(value = "回答管理API接口",description = "回答管理API接口，不需要通过身份认证就可以访问")
@RestController
@RequestMapping("/api/replay")
public class ApiReplayController {
    @Autowired
    private IReplayService replayService;

    @ApiOperation("通过问题ID递归查询所有评论")
    @ApiImplicitParam(name = "questionId",value = "问题ID",required = true)
    @GetMapping("/list/{questionId}")
    public Result findByQuestionId(@PathVariable("questionId") String questionId){
        return replayService.findByQuestionId(questionId);
    }
    @ApiOperation("新增回答信息接口")
    @PutMapping
    public Result add(@RequestBody Replay replay ){
        return replayService.add(replay);
    }
}
