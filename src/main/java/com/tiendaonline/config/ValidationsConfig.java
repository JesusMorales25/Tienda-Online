package com.tiendaonline.config;

import com.tiendaonline.services.models.validation.CustomerValidations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationsConfig {

    @Bean
    public CustomerValidations customerValidations(){
        return new CustomerValidations();
    }
}
