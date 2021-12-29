package com.mengxuegu.blog.util.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "mengxuegu.blog")
public class BlogProperties implements Serializable {

    // 会将 mengxuegu.blog.aliyun 下的配置绑定到 AliyunProperties 对象属性上
    private AliyunProperties aliyun;

}
