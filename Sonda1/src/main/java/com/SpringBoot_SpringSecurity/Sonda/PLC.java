package com.SpringBoot_SpringSecurity.Sonda;



import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//   proxy for Sonda
// salva le misurazioni della sonda nella lista "misure",
// implementare salvataggio in db in secondo momento per applicazione più realistica

@Component
@Getter
public class PLC implements Dispositivo{
    Logger log= LoggerFactory.getLogger(PLC.class);

    @Autowired
    private SondaDTO sondaDTO;

    @Value("${centroDiControllo.url}") private String urlCentroControllo;

    private List<MisuraDTO> misure= new ArrayList<>();

    /*
    * effettua misura fumo e la salva nella lista "misure"
    *
    * logga misura
    *
    * ritorna misura
    * */
    @Override
    public int misuraFumo() {

      var misura= sondaDTO.misuraFumo();

      misure.add(new MisuraDTO(misura, new Timestamp(new Date().getTime())));
      log.info("misura ricevuta: "+misura);
      return misura;
    }

}
