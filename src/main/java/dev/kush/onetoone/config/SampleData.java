package dev.kush.onetoone.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleData {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
