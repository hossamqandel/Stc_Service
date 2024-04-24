package com.example.stcservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration { // Bean

    @Bean
//    @Scope("prototype")
    public ModelMapper createModelMapperBean() {
        System.out.println("Create new ModelMapper object");
        return new ModelMapper();
    }

    // 1- Managed by spring container/context
    // 2- Singleton object - Default bean scope of spring
    // 3- Inject any required dependencies

}
