package com.mengxuegu.blog.question.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mengxuegu.blog.entities.Label;
import com.mengxuegu.blog.entities.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;

import java.util.List;

/**
 * <p>
 * 问题信息表 Mapper 接口
 * </p>
 *
 * @author byl
 * @since 2021-11-26
 */
public interface QuestionMapper extends BaseMapper<Question> {
   IPage<Question> findListByLabelId(IPage<Question> page,
                                     @Param("labelId") String labelId);
   /**
    * 注意：Question类中要加上 List<String> labelIds
    * 根据问题ID查询问题详情与标签ids
    * @param id 问题id
    * @return
    */

   Question findQuestionAndLabelIdsById(String id);
   /**
    * 通过问题 id 删除问题标签中间表
    * @param questionId 问题id
    * @return
    */
   boolean deleteQuestionLabel(@Param("questionId") String questionId);

   /**
    * 新增问题标签中间表数据
    * @param questionId 问题id
    * @param labelIds 标签集合
    * @returnaslist
    * */
   boolean saveQuestionLabel(@Param("questionId") String questionId,
                             @Param("labelIds")List<String> labelIds);

}
