package com.SpringBoot_SpringSecurity.CentroPersonale;

import com.SpringBoot_SpringSecurity.sonda.MisuraDTO;
import com.SpringBoot_SpringSecurity.sonda.SondaDTO;

import java.util.List;

public interface Observer {


    public void update(MisuraDTO misura, SondaDTO sonda);

}
