package com.example.boot.user.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.boot.user.mapper",sqlSessionFactoryRef = "sqlSessionFactory")
public class UserSqlSessionFactoryConfig {

    @Autowired
    private DataSource firstDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
      var factoryBean= new SqlSessionFactoryBean();
      factoryBean.setDataSource(firstDataSource);
      factoryBean.setTypeAliasesPackage("com.example.boot.user.model");
      return factoryBean.getObject();
    }
}
