package com.example.boot.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import javax.sql.XADataSource;

/**
 * 实现XA分布式事务 2PC
 */
@Log
@Configuration
public class DataSourceConfig {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.first")
//    public XADataSource initFirstDataSource() {
//        return new MysqlXADataSource("jdbc:mysql://localhost:3306/user","root","");
//    }

    public XADataSource initDataSource(String url,String name,String password){
        MysqlXADataSource xaDataSource=new MysqlXADataSource();
        xaDataSource.setUrl(url);
        xaDataSource.setUser(name);
        xaDataSource.setPassword(password);
        return xaDataSource;
    }

    @Bean(name = "firstDataSource")
    @Primary
    public DataSource firstDataSource() {
        log.info("创建第一个数据源");
        var xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(initDataSource("jdbc:mysql://localhost:3306/user","root","Zyc19980518@"));
        xaDataSource.setUniqueResourceName("mysqlFirstDataSource");
        return xaDataSource;
    }

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.second")
//    public XADataSource initSecondDataSource() {
//        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
//        mysqlXADataSource.setPort(3306);
//        mysqlXADataSource.setUrl("jdbc:mysql://127.0.0.1:3306/exam");
//        mysqlXADataSource.setUser("root");
//        mysqlXADataSource.setPassword("Zyc19980518@");
//        return new MysqlXADataSource();
//    }

    @Bean("secondDataSource")
    public DataSource secondDataSource() {
        log.info("创建第二个数据源");
        var xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(initDataSource("jdbc:mysql://localhost:3306/exam","root","Zyc19980518@"));
        xaDataSource.setUniqueResourceName("mysqlSecondDataSource");
        return xaDataSource;
    }

}
