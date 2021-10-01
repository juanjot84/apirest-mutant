package com.erParcial.apirestmutant.repositories;


import com.erParcial.apirestmutant.entities.Mutant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantRepository extends BaseRepository<Mutant, Long> {

    @Query(
            value = "SELECT COUNT(*) FROM adn_verificados",
            nativeQuery = true
    )
    int contTotalDna();

    @Query(
            value = "SELECT COUNT(*) FROM adn_verificados WHERE adn_verificados.clasificacion = 'mutante'",
            nativeQuery = true
    )
    int contTotalMutantes();
}

