package com.mengxuegu.blog.article.controller;


import com.mengxuegu.blog.article.service.ICommentService;
import com.mengxuegu.blog.entities.Comment;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 评论信息表 前端控制器
 * </p>
 *
 * @author byl
 */
@Api(value = "评论管理接口", description = "评论管理接口，提供评论的增删改查")
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    // 这个应该是公开api接口，把它放到 com.mengxuegu.blog.article.api.ApiArticleController
//    @ApiOperation("通过文章ID递归查询所有评论")
//    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true)
//    @GetMapping("/list/{articleId}") // get 方式 /article/comment/list/1
//    public Result findByArticleId(@PathVariable("articleId") String articleId) {
//        return commentService.findByArticleId(articleId);
//    }

    @ApiImplicitParam(name = "id", value = "评论ID", required = true)
    @ApiOperation("删除评论接口")
    @DeleteMapping("/{id}")
    public Result delete( @PathVariable("id") String id) {
        return commentService.deleteById(id);
    }

    @ApiOperation("新增评论信息接口")
    @PostMapping
    public Result save(@RequestBody Comment comment) {
        commentService.save(comment);
        return Result.ok();
    }


}
