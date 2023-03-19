package com.SpringBoot_SpringSecurity.sonda;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SondaService {

    @Autowired private SondaRepository repo;


    //create
    public void create(SondaDTO dto){
        repo.save(dto);
    }

    //read
    public SondaDTO getByID(Long id){
        return repo.findById(id).orElseThrow(()->new EntityNotFoundException("La sonda con questo id non esiste nel db!!"));
    }

    public List<SondaDTO> getAll(){
        return (List<SondaDTO>) repo.findAll();
    }

    //update

    //delete
    public void deleteByID(Long id){
        repo.deleteById(id);
    }

}
