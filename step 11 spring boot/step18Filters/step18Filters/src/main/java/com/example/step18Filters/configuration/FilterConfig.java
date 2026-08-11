package com.example.step18Filters.configuration;

import com.example.step18Filters.filter.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilter(){

        FilterRegistrationBean<DummyFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());

        registrationBean.setOrder(2);
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setName("dummyFilterBean");

        return registrationBean;
    }

}
