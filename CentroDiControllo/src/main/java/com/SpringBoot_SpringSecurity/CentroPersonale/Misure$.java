package com.SpringBoot_SpringSecurity.CentroPersonale;

import com.SpringBoot_SpringSecurity.sonda.MisuraDTO;
import com.SpringBoot_SpringSecurity.sonda.SondaDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//subject che emette info ai subscribers (i vari centri del personale) sulle misure
@Component
public class Misure$ {

    private List<SondaDTO> sonde= new ArrayList<>();
    private List<CentroPersonale> centriPersonale=new ArrayList<>();

    public void notifyAllarme(MisuraDTO misura, SondaDTO s){
        centriPersonale.forEach(centroPersonale -> centroPersonale.update(misura, s));
    }

    public void addCentroPersonale(CentroPersonale c){
        centriPersonale.add(c);
    }

    public void updateUrlCentroPersonale(Long id, String newUrl){
        centriPersonale.forEach(centroPersonale -> {
            if(centroPersonale.getId().equals(id)) centroPersonale.setUrl(newUrl);
        });
    }

    public void deleteCentroPersonale(CentroPersonale c){
        centriPersonale.remove(c);
    }


    public void addSonda(SondaDTO sondaDTO){
        sonde.add(sondaDTO);
    }
}
