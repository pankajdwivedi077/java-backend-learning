package com.example.step19Interceptors.config;

import com.example.step19Interceptors.interceptor.AuthInterceptor;
import com.example.step19Interceptors.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;
    public AuthInterceptor authInterceptor;

    @Autowired
    public WebConfig(LoggingInterceptor loggingInterceptor,
                     AuthInterceptor authInterceptor){
        this.loggingInterceptor = loggingInterceptor;
        this.authInterceptor = authInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/**")
                .order(2);

        registry.addInterceptor(authInterceptor)
                .excludePathPatterns("/api/auth/login", "/api/public")
                .order(1);

    }

}
