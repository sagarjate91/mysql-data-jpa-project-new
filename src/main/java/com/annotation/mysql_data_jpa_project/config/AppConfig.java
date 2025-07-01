package com.annotation.mysql_data_jpa_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.annotation.mysql_data_jpa_project.service.Tester;

@Configuration
public class AppConfig {

    @Bean
    public Tester tester() {
        return new Tester();
    }

}
