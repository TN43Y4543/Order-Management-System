package com.sonyadminportal.AdminApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate createBeanObject()
    {
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate;
    }
}
