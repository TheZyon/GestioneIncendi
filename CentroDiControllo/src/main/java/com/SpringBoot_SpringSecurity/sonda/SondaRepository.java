package com.SpringBoot_SpringSecurity.sonda;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SondaRepository extends CrudRepository<SondaDTO, Long> {
}
