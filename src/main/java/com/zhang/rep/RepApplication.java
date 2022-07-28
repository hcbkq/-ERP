package com.zhang.rep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Configuration
@SpringBootApplication
@MapperScan("com.zhang.rep.mapper")
//注解指定当前项目中的Mapper接口路径的位置，在项目启动后会自动加载所有接口
public class RepApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepApplication.class, args);
    }

    @Bean
    public MultipartConfigElement getMultipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
        factory.setMaxRequestSize(DataSize.of(15,DataUnit.MEGABYTES));

        return factory.createMultipartConfig();
    }

}
