package com.example.boot.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * mybatis-plus 分页插件
 */
@Configuration
public class PaginConfig {

    @Bean(name = "pageInterceptor")
    public MybatisPlusInterceptor pageInterceptor(){
      var pagin= new MybatisPlusInterceptor();
      pagin.setInterceptors(List.of(new PaginationInnerInterceptor()));
      return pagin;
    }
}
