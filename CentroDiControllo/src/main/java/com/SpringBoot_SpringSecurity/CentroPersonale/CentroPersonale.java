package com.SpringBoot_SpringSecurity.CentroPersonale;

import com.SpringBoot_SpringSecurity.sonda.MisuraDTO;
import com.SpringBoot_SpringSecurity.sonda.SondaDTO;
import com.SpringBoot_SpringSecurity.sonda.SondaService;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="centri_personale")
public class CentroPersonale implements Observer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String url;

    @Override
    public void update(MisuraDTO misura, SondaDTO sonda) {
        //manda info a centro personale con RestTemplate
        RestTemplate rt= new RestTemplate();

        //io avrei comunicato anche la data al centro personale
        //ma dalla traccia dell'esercizio si intende che i dati vadano passati via query string
        //e nella query string non vada inserita la data...
        rt.getForEntity(
                url+"/alarm"+
                        "/" +sonda.getId()+
                        "/" + sonda.getLatitudine()+
                        "/"+ sonda.getLongitudine()+
                        "/"+misura.getValoreFumo(), String.class);
    }
}