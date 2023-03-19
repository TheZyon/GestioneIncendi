package com.SpringBoot_SpringSecurity.runner;

import com.SpringBoot_SpringSecurity.Sonda.PLC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class SondaRunner implements ApplicationRunner {


    @Autowired private PLC plc;



    @Override
    public void run(ApplicationArguments args) throws Exception {



        segnalaAttivazioneSonda(); //attivo la sonda ---> lo segnalo al centro di controllo con una POST request


        Timer timer = new Timer();
        int begin = 0;
        int timeInterval = 1000;
        timer.schedule(new TimerTask() { //a class that has a method "run" that tells the business logic of the task

            @Override
            public void run() {
                             if(plc.misuraFumo()==5) segnalaFumoEccessivo();

            }
        }, begin, timeInterval);


    }

    public void segnalaAttivazioneSonda(){ //segnala al centro di controlla la creazione di una nuova sonda
        var url= plc.getUrlCentroControllo();
        RestTemplate rt= new RestTemplate();
        rt.postForEntity(url+"/sonde", plc.getSondaDTO(), String.class);
    }

    public void segnalaFumoEccessivo(){
        var url= plc.getUrlCentroControllo();
        RestTemplate rt=new RestTemplate();
        rt.postForEntity(url+"/sonde/"+plc.getSondaDTO().getId()+"/allarme", "", String.class);

    }


}
