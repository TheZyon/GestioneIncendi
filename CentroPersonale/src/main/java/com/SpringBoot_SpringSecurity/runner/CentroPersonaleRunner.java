package com.SpringBoot_SpringSecurity.runner;

import com.SpringBoot_SpringSecurity.DTO.CentroPersonaleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CentroPersonaleRunner implements ApplicationRunner {
    @Value("${centroDiControllo.url}") private String urlCentroDiControllo;
    @Autowired private CentroPersonaleDTO centroPersonaleDTO;
    Logger log= LoggerFactory.getLogger(CentroPersonaleRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {

    registerCentroPersonale();


    }

    public void registerCentroPersonale(){//registro il centro personale tra i centri riconosciuti dal CentroDiControllo

        RestTemplate rt= new RestTemplate();
        var res= rt.postForEntity(urlCentroDiControllo+ "/centri_personale",centroPersonaleDTO, String.class);
        log.info("RESPONSO: "+res.getBody());

    }




}
