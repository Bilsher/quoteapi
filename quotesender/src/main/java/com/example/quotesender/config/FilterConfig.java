package com.example.quotesender.config;

import com.example.quotesender.filters.AuthFilter;
//import com.example.quotesender.filters.ForbiddenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthFilter> filterAuthCheckBean(){
        final FilterRegistrationBean<AuthFilter> authBean = new FilterRegistrationBean<>();
        authBean.setFilter(new AuthFilter());
//        authBean.addUrlPatterns("/api/v1/quotes/allUsers","/api/v1/quotes/logOut");
        authBean.setOrder(0);
        return authBean;
    }

//    @Bean
//    public FilterRegistrationBean<ForbiddenFilter> filterForbiddenBean(){
//        final FilterRegistrationBean<ForbiddenFilter> forbiddenBean = new FilterRegistrationBean<>();
//        forbiddenBean.setFilter(new ForbiddenFilter());
//        forbiddenBean.addUrlPatterns("/api/v1/quotes/registration","/api/v1/quotes/login");
//        forbiddenBean.setOrder(0);
//        return forbiddenBean;
//    }
}
