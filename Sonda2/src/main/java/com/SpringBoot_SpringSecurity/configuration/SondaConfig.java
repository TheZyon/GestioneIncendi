package com.SpringBoot_SpringSecurity.configuration;

import com.SpringBoot_SpringSecurity.Sonda.SondaDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SondaConfig {


    @Value("${sonda.latitudine}") private double latitudine;
    @Value("${sonda.longitudine}") private double longitudine;
    @Value("${sonda.id}") private Long id;

    @Bean
    public SondaDTO getSonda(){
        return new SondaDTO(id, longitudine, latitudine);
    }

}
