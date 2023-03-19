package com.SpringBoot_SpringSecurity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
public class MisuraDTO {

    private Integer valoreFumo;

    private Timestamp dataMisura;

}
