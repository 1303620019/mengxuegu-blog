package com.mengxuegu.blog.article.req;

import com.mengxuegu.blog.entities.Article;
import com.mengxuegu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文章列表查询条件
 */
@Data
@Accessors(chain = true)
@ApiModel(value="ArticleListREQ对象", description = "文章列表查询条件")
public class ArticleListREQ extends BaseRequest<Article> {

    @ApiModelProperty(value = "分类ID")
    private String categoryId;

    @ApiModelProperty(value = "标签ID")
    private String labelId;
}
