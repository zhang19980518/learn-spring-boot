package com.example.boot.exam.config;


import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@MapperScan(basePackages = "com.example.boot.exam.mapper",sqlSessionFactoryRef = "sqlSessionFactory2")
public class ExamSqlSessionFactoryConfig {
    @Autowired
    @Qualifier("secondDataSource")
    private DataSource secondDataSource;
    @Autowired
    private MybatisPlusInterceptor pageInterceptor;

    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        var sqlSessionFactoryBean=new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(secondDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.boot.exam.model");
        sqlSessionFactoryBean.setPlugins(pageInterceptor);
        return sqlSessionFactoryBean.getObject();
    }
}
