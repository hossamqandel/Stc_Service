package com.example.stcservice.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration { // Bean

    @Bean
    public ModelMapper createModelMapper() {
        ModelMapper dtoMapper = new ModelMapper();
        dtoMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return dtoMapper;
    }

    // 1- Managed by spring container/context
    // 2- Singleton object - Default bean scope of spring
    // 3- Inject any required dependencies

}
