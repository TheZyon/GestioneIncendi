package com.SpringBoot_SpringSecurity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CentroPersonaleDTO {
    @Value("${home.url}")
    private String url;

    @Value("${home.id}")private long id;


}
