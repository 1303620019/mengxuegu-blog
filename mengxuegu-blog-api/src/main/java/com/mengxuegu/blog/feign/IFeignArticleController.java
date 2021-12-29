package com.mengxuegu.blog.feign;

import com.mengxuegu.blog.entities.Label;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @description:
 *      @FeignClient 注解说明：
 * value 指定是哪个微服务接口，
 * path 是在 Feign 调用时会加上此前缀，它与接口实现类的微服务中配置的 context-path 值一致，
 * 如果微服务中没有配置 context-path 下面就不需要写 path
 * @projectName:mengxuegu-blog
 * @see:com.mengxuegu.blog.feign
 * @author:byl
 * @createTime:2021/12/2 11:58
 * @version:1.0
 */

//value 指定是哪个微服务
// path 是在feign 调用的时会加上此前缀，它与接口实现类的微服务中的配置的 context-path 值一致
// 如果微服务中没有配置  context-path 下面就不需要写paht了。
@FeignClient(value = "article-server",path = "/article")
public interface IFeignArticleController {
    // allowMultiple=true 表示数组格式的参数,dataType="String" 表示数组中参数的类型
    @ApiImplicitParam(allowMultiple = true,dataType = "String",
                     name="ids",value = "标签ID集合",required = true)
    @ApiOperation("Feign接口-根据标签ids查询对应的标签信息")
    @GetMapping("/api/feign/label/list/{ids}")// @PathVariable(一定要指定"ids")
    List<Label> getLabelListByIds(@PathVariable("ids") List<String> ids);


}
