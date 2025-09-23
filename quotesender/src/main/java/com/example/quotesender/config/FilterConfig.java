package com.example.quotesender.config;

import com.example.quotesender.filters.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthFilter> filterAuthCheckBean(){
        final FilterRegistrationBean<AuthFilter> authBean = new FilterRegistrationBean<>();
        authBean.setFilter(new AuthFilter());
        authBean.setOrder(0);
        return authBean;
    }
}
