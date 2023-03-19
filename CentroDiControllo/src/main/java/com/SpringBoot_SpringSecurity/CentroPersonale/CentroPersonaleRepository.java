package com.SpringBoot_SpringSecurity.CentroPersonale;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroPersonaleRepository extends CrudRepository<CentroPersonale,Long> {
}
