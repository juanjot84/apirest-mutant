package com.erParcial.apirestmutant.repositories;


import com.erParcial.apirestmutant.entities.Mutant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantRepository extends BaseRepository<Mutant, Long> {

    @Query(
            value = "SELECT COUNT(*) FROM Mutant",
            nativeQuery = false
    )
    int contTotalDna();

    @Query(
            value = "SELECT COUNT(*) FROM Mutant m WHERE m.clasificacion = 'mutante'",
            nativeQuery = false
    )
    int contTotalMutantes();
}

