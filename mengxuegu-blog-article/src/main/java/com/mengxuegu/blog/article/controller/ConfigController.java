package com.mengxuegu.blog.article.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:mengxuegu-blog
 * @see:com.mengxuegu.blog.article.config
 * @author:byl
 * @createTime:2021/12/1 11:25
 * @version:1.0
 */
@RefreshScope
@RestController
public class ConfigController {
    //会从nacos中的DataID为 article-server.yml 中获取
    @Value("${user.name}")
    private String name;
//    @Value("${user.age}")
//    private Integer age;
    //请求访问
    @RequestMapping("/config")
    public String getConfig() {
        String content = "name:" + name ;
        System.out.println("name: " + content);
        return content;
    }
}
