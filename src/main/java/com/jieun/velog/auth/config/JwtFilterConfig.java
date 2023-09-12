package com.jieun.velog.auth.config;

import com.jieun.velog.auth.jwt.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtFilterConfig {
    @Bean
    public FilterRegistrationBean jwtRegFilter(final JwtFilter jwtFilter) {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(jwtFilter);

        filter.addUrlPatterns("/api/v1/asdgs/*");
        return filter;
    }
}
