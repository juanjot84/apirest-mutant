package com.erParcial.apirestmutant.repositories;


import com.erParcial.apirestmutant.entities.Mutant;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantRepository extends BaseRepository<Mutant, Long> {
}
