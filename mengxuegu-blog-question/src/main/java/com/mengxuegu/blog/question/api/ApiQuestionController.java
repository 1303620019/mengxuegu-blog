package com.mengxuegu.blog.question.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mengxuegu.blog.entities.Question;
import com.mengxuegu.blog.question.service.IQuestionService;
import com.mengxuegu.blog.util.base.BaseRequest;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @description:
 * @projectName:mengxuegu-blog
 * @see:com.mengxuegu.blog.question.api
 * @author:byl
 * @createTime:2021/11/26 15:39
 * @version:1.0
 */

@Api(value = "问答管理APOI接口", description = "问答管理API接口，不需要通过身份认证即可调用接口")
@RestController
@RequestMapping("/api/question")
public class ApiQuestionController {
    @Autowired
    private IQuestionService questionService;
    @ApiOperation("分页查询热门问答列表接口")
    @PostMapping("/hot") // /api/question/hot
    public Result findHostList(@RequestBody BaseRequest<Question> req) {
        return questionService.findHotList(req);
    }

    @ApiOperation("分页查询等待回答列表")
    @PostMapping("/wait")
    public Result findWaitList(@RequestBody BaseRequest<Question> req){
        return questionService.findHotList(req);
    }
    @ApiModelProperty(name = "labelId",value = "标签ID",required = true)
    @ApiOperation("根据标签ID分页查询问答列表接口")
    @PostMapping("/list/{labelId}")
    public Result findListByLabelId(@RequestBody BaseRequest<Question> req,
                                    @PathVariable("labelId") String labelId){
        return Result.ok( questionService.findListByLabelId(req,labelId) );
    }
   @ApiModelProperty(name = "id",value = "问题ID",required = true)
   @ApiOperation("查询问题详情接口")
   @GetMapping("/{id}")
    public Result view(@PathVariable("id") String id){
        return  Result.ok( questionService.findId(id) );
    }

    @ApiOperation("更新浏览次数")
    @ApiModelProperty(name = "id",value = "问题ID",required = true)
    @PutMapping("/viewCount/{id}")
    public Result updateViewCount (@RequestBody BaseRequest<Question>req,
                                   @PathVariable("id") String id){

        return  Result.ok( questionService.updateViewCount(id) );
    }

}
