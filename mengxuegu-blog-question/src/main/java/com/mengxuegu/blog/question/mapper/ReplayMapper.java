package com.mengxuegu.blog.question.mapper;

import com.mengxuegu.blog.entities.Replay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 回答信息表 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2021-11-26
 */
public interface ReplayMapper extends BaseMapper<Replay> {
    /**
    * 功能描述: <br>
    * 〈通过问题id递归查询所有回答〉
    * @Param: [questionId]
    * @Return: java.util.List<com.mengxuegu.blog.entities.Replay>
    * @Author: byl
    * @Date:  
    */
    List<Replay> findByQuestionId(String questionId);

}
