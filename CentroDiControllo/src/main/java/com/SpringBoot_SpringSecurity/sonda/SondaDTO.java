package com.SpringBoot_SpringSecurity.sonda;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="sonde")
public class SondaDTO implements Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private double longitudine;
    @NonNull
    private double latitudine;
    @NonNull
    @Column(name="url_sonda")
    private String urlSonda;
    @Override
    public int misuraFumo() {
        //per il test facciamo ritornare dei numeri casuali
        return (int) Math.round(Math.random() * 5);

    }
}