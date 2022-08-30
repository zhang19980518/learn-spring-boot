package com.example.boot.config;


import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MPConfig {

    @Bean
    public GlobalConfig globalConfig(){
        GlobalConfig globalConfig=new GlobalConfig();
        globalConfig.setBanner(false);
        return globalConfig;
    }
}
