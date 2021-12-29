package com.mengxuegu.blog.article.service;

import com.mengxuegu.blog.article.req.LabelREQ;
import com.mengxuegu.blog.entities.Label;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author byl
 */
public interface ILabelService extends IService<Label> {

    /**
     * 条件分页查询标签列表
     * @param req
     * @return
     */
    Result queryPage(LabelREQ req);
}
