package com.mengxuegu.blog.question.service;

import com.mengxuegu.blog.entities.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.question.req.QuestionUserREQ;
import com.mengxuegu.blog.util.base.BaseRequest;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 问题信息表 服务类
 * </p>
 *
 * @author byl
 * @since 2021-11-26
 */
public interface IQuestionService extends IService<Question> {

    /**
     * 查询热门回答列表
     * @param req
     * @return
     */
      Result findHotList(BaseRequest<Question> req);
      /**
      * 功能描述: <br>
      * 〈查询最新问答列表〉
      * @Param: [req]
      * @Return: com.mengxuegu.blog.util.base.Result
      * @Author: byl
      * @Date:  
      */
      Result findNewList(BaseRequest<Question> req);

    /**
     * 分页查询等待回答列表
     * @param
     * @return
     */
      Result findWaitList(BaseRequest<Question> req);
    /**
     * 根据标签id分页查询问题列表
     * @param req 分页相关的对象
     * @param labelId 标签id
     * @return
     */
      Result findListByLabelId(BaseRequest<Question> req,String labelId);
    /**
     * 通过问题id查询详情
     * @param id 问题id
     * @return
     */
      Result findId(String id);
    /**
     * 更新浏览次数
     * @param id
     * @return
     */
      Result updateViewCount(String id);
    /**
     * 修改或新增问题数据
     * @param question
     * @return
     */
     Result UpdateOrSave(Question question);
    /**
     * 假删除，通过 问题id 修改状态为 0 ，表示已删除
     * @param id 问题id
     * @return
     */
    Result deleteById(String id);
    /**
     * 更新点赞数
     * @param id
     * @param count
     * @return
     */
    Result updateThumhup(String id,int count);


    /**
     * 根据用户ID查询问题列表
     * @return
     */
    Result findListByUserId(QuestionUserREQ req);


    Result getQuestionTotal();
}
