package com.erParcial.apirestmutant.services;

import com.erParcial.apirestmutant.entities.Mutant;
import com.erParcial.apirestmutant.entities.SearchMutant;
import com.erParcial.apirestmutant.entities.StastsDTO;
import com.erParcial.apirestmutant.repositories.BaseRepository;
import com.erParcial.apirestmutant.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl  extends BaseServiceImpl<Mutant, Long> implements MutantService {

    @Autowired
    private MutantRepository mutantRepository;

    public MutantServiceImpl(BaseRepository<Mutant, Long> baseRepository) {
        super(baseRepository);
    }

    public StastsDTO getStast() throws Exception{
        try {
            StastsDTO stastsDTO = new StastsDTO();
            stastsDTO.setCount_human_dna(  mutantRepository.contTotalDna() - mutantRepository.contTotalMutantes() );
            stastsDTO.setCount_mutant_dna( mutantRepository.contTotalMutantes() );
            float contTotMutant = (float) mutantRepository.contTotalMutantes();
            float contTotHum = (float) (mutantRepository.contTotalDna() - mutantRepository.contTotalMutantes());
            float ratio =  contTotMutant / contTotHum;
            stastsDTO.setRatio( ratio );

            return stastsDTO;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Mutant isMutant(String[] dna) throws Exception {
        SearchMutant searchMutant = new SearchMutant();
        return searchMutant.buscarMutante(dna);
    }

}

