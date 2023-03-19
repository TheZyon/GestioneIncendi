package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.CentroPersonale.CentroPersonale;
import com.SpringBoot_SpringSecurity.CentroPersonale.CentroPersonaleService;
import com.SpringBoot_SpringSecurity.CentroPersonale.Misure$;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centri_personale")
public class CentriPersonaleController {

    Logger log= LoggerFactory.getLogger(SondeController.class);

    @Autowired private CentroPersonaleService service;
    @Autowired private Misure$ misure$;
    @PostMapping
    public ResponseEntity<String> registerCentroPersonale(@RequestBody CentroPersonale c){

        service.create(c);
        misure$.addCentroPersonale(c);
        return new ResponseEntity<>("Centro personale di id "+c.getId()+" registrato!", HttpStatus.OK);
    }



}
