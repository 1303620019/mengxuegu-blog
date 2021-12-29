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
 * @createTime:2021/12/2 15:00
 * @version:1.0
 */
@EnableDiscoveryClient //标识 Nacos 客户端
@EnableSwagger2Doc //启动swagger
@SpringBootApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }
}
