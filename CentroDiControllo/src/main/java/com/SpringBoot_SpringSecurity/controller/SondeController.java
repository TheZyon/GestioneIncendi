package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.CentroPersonale.Misure$;
import com.SpringBoot_SpringSecurity.sonda.MisuraDTO;
import com.SpringBoot_SpringSecurity.sonda.SondaDTO;
import com.SpringBoot_SpringSecurity.sonda.SondaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/sonde")
public class SondeController {

    Logger log= LoggerFactory.getLogger(SondeController.class);
    @Autowired private SondaService sondaService;
    @Autowired private Misure$ misure$;

    @PostMapping
    public ResponseEntity<String> createSonda(@RequestBody SondaDTO sondaDTO){
    //è stata attivata una nuova sonda---> la salviamo nel db delle sonde
    sondaService.create(sondaDTO);
    misure$.addSonda(sondaDTO);

    return new ResponseEntity<>("Sonda aggiunta", HttpStatus.OK);

    }

    @PostMapping("/{id}/allarme")
    public ResponseEntity<String> segnalaFumo(@PathVariable Long id){
        //si invia messaggio ai centri del personale usando il subject!!
        misure$.notifyAllarme(new MisuraDTO(5, new Timestamp((new Date()).getTime())), sondaService.getByID(id));
        //temporaneamente si logga soltanto
        log.info("ATTENZIONE LA SONDA DI ID: "+id+ " SEGNALA FUMO!!!!!");


        return new ResponseEntity<>("Messaggio inviato!", HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SondaDTO> getSonda(@PathVariable Long id){
        return new ResponseEntity<>(sondaService.getByID(id), HttpStatus.OK);
    }


}
