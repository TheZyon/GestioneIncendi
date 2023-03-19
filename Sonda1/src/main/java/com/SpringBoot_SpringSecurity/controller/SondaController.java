package com.SpringBoot_SpringSecurity.controller;


import com.SpringBoot_SpringSecurity.Sonda.MisuraDTO;
import com.SpringBoot_SpringSecurity.Sonda.PLC;
import com.SpringBoot_SpringSecurity.Sonda.SondaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class SondaController {

    @Value("${centroDiControllo.url}") private String urlCentroDiControllo;

    @Autowired private PLC plc;

    @GetMapping("/misure")
    public ResponseEntity<List<MisuraDTO>> getMisure(){
        return new ResponseEntity<>(plc.getMisure(), HttpStatus.OK);
    }

    @GetMapping("/infoSonda")
    public ResponseEntity<SondaDTO> getSondaInfo(){
        return new ResponseEntity<>(plc.getSondaDTO(), HttpStatus.OK);
    }

}
