package com.example.boot.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Compression;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

@Configuration
public class WebConfig  {
    /**
     * ConfigurableServletWebServerFactory对web服务进行配置
     * @return
     */
    @Bean
    public ConfigurableServletWebServerFactory configurableWebServerFactory(){
        TomcatServletWebServerFactory factory=new TomcatServletWebServerFactory();
        factory.setPort(8899);
        factory.setContextPath("/api");
        Compression compression=new Compression();
        compression.setEnabled(true);
        compression.setMinResponseSize(DataSize.ofBytes(1024));
        factory.setCompression(compression);
        return factory;
    }

}
