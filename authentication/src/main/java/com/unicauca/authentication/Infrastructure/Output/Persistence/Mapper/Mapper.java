package com.unicauca.authentication.Infrastructure.Output.Persistence.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper createMapper(){
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}
