package com.example.boot.exam.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.boot.exam.mapper",sqlSessionFactoryRef = "sqlSessionFactory2")
public class ExamSqlSessionFactoryConfig {
    @Autowired
    @Qualifier("secondDataSource")
    private DataSource secondDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        var factoryBean= new SqlSessionFactoryBean();
        factoryBean.setDataSource(secondDataSource);
        factoryBean.setTypeAliasesPackage("com.example.boot.exam.model");
        return factoryBean.getObject();
    }
}
