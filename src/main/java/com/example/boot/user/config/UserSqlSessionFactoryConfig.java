package com.example.boot.user.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.boot.user.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class UserSqlSessionFactoryConfig {

    @Autowired
    private DataSource firstDataSource;

    @Autowired
    private MybatisPlusInterceptor pageInterceptor;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        var sqlSessionFactoryBean=new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(firstDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.boot.user.model");
        sqlSessionFactoryBean.setPlugins(pageInterceptor);
        return sqlSessionFactoryBean.getObject();
    }
}
