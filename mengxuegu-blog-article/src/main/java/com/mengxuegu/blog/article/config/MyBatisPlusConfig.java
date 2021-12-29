package com.mengxuegu.blog.article.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import javafx.scene.control.Pagination;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 开启事务管理
@MapperScan("com.mengxuegu.blog.article.mapper") // 扫描mapper接口
@Configuration
public class MyBatisPlusConfig {

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
