package com.SpringBoot_SpringSecurity.CentroPersonale;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroPersonaleService {

    @Autowired private CentroPersonaleRepository repo;
    //create
    public void create(CentroPersonale c){
        repo.save(c);
    }

    //retrieve
    public CentroPersonale getById(Long id){
        return repo.findById(id).orElseThrow(()->new EntityNotFoundException("Centro personale con questo id non esiste!"));
    }

    public List<CentroPersonale> getAll(){
        return (List<CentroPersonale>) repo.findAll();
    }

    //update
    public void update(CentroPersonale c){
        repo.save(c);
    }

    //delete

    public void deleteById(Long id){
        repo.deleteById(id);
    }

}
