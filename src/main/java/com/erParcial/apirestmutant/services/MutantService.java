package com.erParcial.apirestmutant.services;

import com.erParcial.apirestmutant.entities.Mutant;
import com.erParcial.apirestmutant.entities.StastsDTO;

public interface MutantService extends BaseService<Mutant, Long> {

    Mutant isMutant(String[] dna) throws Exception;
    StastsDTO getStast() throws Exception;
}
