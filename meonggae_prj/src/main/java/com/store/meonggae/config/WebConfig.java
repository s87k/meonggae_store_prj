package com.store.meonggae.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.store.meonggae.user.login.interceptor.LoginInterCeptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterCeptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/**"); // 모든 요청에 대해 인터셉터 적용
    }
}

