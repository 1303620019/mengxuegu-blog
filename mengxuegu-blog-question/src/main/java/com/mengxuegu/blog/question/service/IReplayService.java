package com.mengxuegu.blog.question.service;

import com.mengxuegu.blog.entities.Replay;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 回答信息表 服务类
 * </p>
 *
 * @author byl
 * @since 2021-11-26
 */
public interface IReplayService extends IService<Replay> {
    /**
     * 通过问题id级联查询所有回答
     * @param questionId 问题id
     * @return
     */
    Result findByQuestionId(String questionId);

    /***
     * 通过回答评论id递归删除
     * @param id 回答评论id
     * @return
     */
    Result deleteById(String id);
    /**
     * 新增回答并更新问题表中的回答数量
     * @param replay
     * @return
     * */
    Result add(Replay replay);
}
