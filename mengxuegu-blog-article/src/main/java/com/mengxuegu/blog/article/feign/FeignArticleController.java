package com.mengxuegu.blog.article.feign;

import com.mengxuegu.blog.article.service.ILabelService;
import com.mengxuegu.blog.entities.Label;
import com.mengxuegu.blog.feign.IFeignArticleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @projectName:mengxuegu-blog
 * @see:com.mengxuegu.blog.feign
 * @author:byl
 * @createTime:2021/12/2 13:53
 * @version:1.0
 */
@RestController //添加上控制层
public class FeignArticleController implements IFeignArticleController {
    @Autowired
    private ILabelService iLabelService;
    @Override
    public List<Label> getLabelListByIds(List<String> ids) {
        return iLabelService.listByIds(ids);
    }
}
