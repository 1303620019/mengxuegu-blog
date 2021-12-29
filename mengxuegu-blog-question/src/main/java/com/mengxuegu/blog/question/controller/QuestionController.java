package com.mengxuegu.blog.question.controller;


import com.mengxuegu.blog.entities.Question;
import com.mengxuegu.blog.question.req.QuestionUserREQ;
import com.mengxuegu.blog.question.service.IQuestionService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 问题信息表 前端控制器
 * </p>
 *
 * @author byl
 * @since 2021-11-26
 */
@Api(value = "问题管理接口",description = "问题管理接口，提供回答的增、删、改、查")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;
    @ApiOperation("修改问题信息接口")
    @PutMapping
    public Result update(@RequestBody Question question){
        return questionService.UpdateOrSave(question);
    }
    @ApiOperation("新增问题信息接口")
    @PostMapping
    public Result save(@RequestBody Question question){
        return questionService.UpdateOrSave(question);
    }
    @ApiOperation("删除问题接口")
    @ApiModelProperty(name = "id",value = "问题ID",required = true)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id){
        return questionService.deleteById(id);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "问题ID",required = true),
            @ApiImplicitParam(name = "count",value = "点赞数",required = true),
    })
    @ApiOperation("更新点赞数")
    @PutMapping("/{id}/{count}")
    public Result updateThumhup(@PathVariable("id") String id,
                                @PathVariable("count") int count){
        return questionService.updateThumhup(id,count);
    }
   @ApiOperation("根据用户ID查询问题列表")
   @PostMapping("/user")
    public Result findListByUserId(@RequestBody QuestionUserREQ req){
        return questionService.findListByUserId(req);
    }
    @ApiOperation("查询提问总记录数")
    @GetMapping("/total")
    public Result questionTotal(){
        return questionService.getQuestionTotal();
    }


    @ApiOperation("查询问题详情")
    @GetMapping("/{id}")
    public Result view(@PathVariable("id") String id){
        return  Result.ok( questionService.findId(id) );
    }

}
