package com.SpringBoot_SpringSecurity.Sonda;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class SondaDTO implements Dispositivo{

    @NonNull
    private Long id;
    @NonNull
    private double longitudine;
    @NonNull
    private double latitudine;
    @Value("${home.url}")
    private String urlSonda;
    @Override
    public int misuraFumo() {
        //per il test facciamo ritornare dei numeri casuali
        return (int)Math.round(Math.random()*5);

    }


}
