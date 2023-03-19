package com.SpringBoot_SpringSecurity.sonda;

import org.springframework.stereotype.Component;

@Component
public class SondaFactory implements DispositivoFactory{
    @Override
    public Dispositivo creaDispositivo(SondaDTO sondaDTO) {//crea Sonda con PLC

      return sondaDTO;
       //TODO: aggiungere db per le varie sonde
       //TODO: aggiungere db per registrare le sonde a Controllo incendi
    }
}
