package com.mengxuegu.blog;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @projectName:mengxuegu-blog
 * @see:com.mengxuegu.blog
 * @author:byl
 * @createTime:2021/11/26 15:05
 * @version:1.0
 */
@EnableFeignClients   //扫描@feign 接口
@EnableDiscoveryClient //   标识为 Nacos 客户端
@EnableSwagger2Doc //开启swagger功能
@SpringBootApplication
public class QuestionApplication {


    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class,args);
    }
}
