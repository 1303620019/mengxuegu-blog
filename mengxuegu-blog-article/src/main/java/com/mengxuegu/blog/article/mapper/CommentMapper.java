package com.mengxuegu.blog.article.mapper;

import com.mengxuegu.blog.entities.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评论信息表 Mapper 接口
 * </p>
 *
 * @author byl
 */
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 通过文章id递归查询所有评论
     * @param articleId
     * @return
     */
    List<Comment> findByArticleId(@Param("articleId") String articleId);

}
