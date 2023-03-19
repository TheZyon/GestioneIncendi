package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.DTO.MisuraDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
public class CentroPersonaleController {

    Logger log= LoggerFactory.getLogger(CentroPersonaleController.class);


    @GetMapping("/alarm/{idSonda}/{lat}/{lon}/{smokelevel}")
    public ResponseEntity<String> signalAllarmeFumo(@PathVariable Long idSonda, @PathVariable double lat, @PathVariable double lon, @PathVariable int smokelevel){
        log.info("ATTENZIONE A TUTTE LE UNITA': la sonda di id "+ idSonda
                + " locata a latitudine e longitudine rispettivamente ("+
                lat + ","+lon+ ") segnala fumo valore "+ smokelevel);
        return new ResponseEntity<>("Allarme ricevuto", HttpStatus.OK);
    }



    //per ottenere le misure effettuate da una sonda..
    /*@GetMapping("/misure/{id_sonda}")
    public ResponseEntity<List<MisuraDTO>> getMisureSonda(){
        RestTemplate rt= new RestTemplate();

        rt.getForEntity()
    }*/

}
