package com.mengxuegu.blog.question.req;

import com.mengxuegu.blog.entities.Question;
import com.mengxuegu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description:
 * @projectName:mengxuegu-blog
 * @see:com.mengxuegu.blog.question.req
 * @author:byl
 * @createTime:2021/11/26 19:12
 * @version:1.0
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "QuestionUserREQ对象",description = "获取指定用户问题的查询条件")
public class QuestionUserREQ extends BaseRequest<Question> {
    @ApiModelProperty(value = "用户ID")
    private String userId;

}
