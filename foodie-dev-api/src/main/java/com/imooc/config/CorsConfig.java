package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    public CorsConfig() {
    }

    @Bean
    public CorsFilter corsFilter(){
        //1.添加cros配置信息
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:8080");
        corsConfiguration.addAllowedOrigin("http://49.233.2.43:8080");
        corsConfiguration.addAllowedOrigin("http://49.233.2.43:8000");
        corsConfiguration.addAllowedOrigin("http://49.233.2.43:8001");

        //设置是否发送cookie信息
        corsConfiguration.setAllowCredentials(true);

        corsConfiguration.addAllowedMethod("*");

        corsConfiguration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsFilter(corsConfigurationSource);
    }
}
