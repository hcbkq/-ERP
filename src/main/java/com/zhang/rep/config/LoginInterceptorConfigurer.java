package com.zhang.rep.config;

import com.zhang.rep.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器的注册
 */
@Configuration  //加载当前的拦截器并进行注册
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建自定义拦截对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        //配置白名单
        List<String> patterns = new ArrayList<>();
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/fonts/**");

        patterns.add("/login.html");

        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/ProvincialAndUrbanStreet/**");
        //完成拦截器的注册
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**") //设置拦截url
                .excludePathPatterns(patterns); //白名单放行
    }
}
