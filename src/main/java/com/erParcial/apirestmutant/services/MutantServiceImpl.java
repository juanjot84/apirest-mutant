package com.erParcial.apirestmutant.services;

import com.erParcial.apirestmutant.entities.Mutant;
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
            int contTotMutant = mutantRepository.contTotalMutantes();
            int contTotHum = mutantRepository.contTotalDna() - contTotMutant;
            Long ratio =  new Long(contTotMutant / contTotHum);
            StastsDTO stastsDTO = new StastsDTO();
            stastsDTO.setCountMutantDna( contTotMutant );
            stastsDTO.setCountHumanDna(  contTotHum );
            stastsDTO.setRatio( ratio );

            return stastsDTO;

        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Mutant isMutant(String[] dna) throws Exception {
        try {

            int contSecuencia = 0;
            String result = "humano";
            int size1 = dna.length - 1;
            int size2 = dna.length;

            for (int i = 0; i < dna.length; i++) {
                contSecuencia += busquedaHorizontal(dna[i]);
                if (contSecuencia > 1) break;
                contSecuencia += busquedaVertical(dna, i);
                if (contSecuencia > 1) break;
                contSecuencia += busquedaOblicua(dna, i, size1, size2);
                if (contSecuencia > 1) break;
                size1--;
                size2++;
            }
            if (contSecuencia < 2 ) contSecuencia = busquedaOblicuaInv(dna, contSecuencia);

            if (contSecuencia > 1) result = "mutante";

            Mutant mutant = new Mutant(dna, result);

            return mutant;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private int busquedaHorizontal(String fila) {
        int contSecHorz = 0;
        for (int j = 3; j < fila.length(); j++) {
            if ( fila.charAt(j) == fila.charAt(j-3) ) {
                if ( fila.charAt(j-2) == fila.charAt(j-1) && fila.charAt(j-1) == fila.charAt(j) ) {
                    contSecHorz++;
                    j += 3;
                }
            }
        }
        return contSecHorz;
    }

    private int busquedaVertical(String[] dna, int i) {
        int contSecVert = 0;
        for (int k = 3; k < dna.length; k++) {
            if ( dna[k].charAt(i) == dna[k-3].charAt(i) ) {
                if ( dna[k-2].charAt(i) == dna[k-1].charAt(i) && dna[k-1].charAt(i) == dna[k].charAt(i) ) {
                    contSecVert++;
                    k += 3;
                }
            }
        }
        return contSecVert;
    }

    private int busquedaOblicua(String[] dna, int i, int size1, int size2) {
        int contSecObl = 0;

        String temp = "";
        for ( int j = 0, x = dna.length-1-i; j < dna.length-i; j++, x--){
            if((j+x) == size1) temp += dna[x].charAt(j);
        }
        if ( temp.length() > 3) contSecObl += busquedaHorizontal(temp);

        temp = "";
        for ( int j = i+1, x = dna.length-1; j < dna.length; j++, x--) {
            if ((j+x)== size2) temp += dna[x].charAt(j);
        }
        if ( temp.length() > 3) contSecObl += busquedaHorizontal(temp);

        return contSecObl;
    }

    private int busquedaOblicuaInv(String[] dna, int contSecuencia) {
        int contSecOblInv = contSecuencia;

        for ( int i = dna.length - 1; i > 0; i--) {
            String temp = "";
            for (int j = 0, x = i; x <= dna.length - 1; j++, x++) {
                temp += dna[x].charAt(j);
            }
            if ( temp.length() > 3) contSecOblInv += busquedaHorizontal(temp);
            if (contSecOblInv > 1) break;
        }

        for ( int i = 0; i <= dna.length - 1; i++) {
            if (contSecOblInv > 1) break;
            String temp = "";
            for (int j = 0, y = i; y <= dna.length - 1; j++, y++ ) {
                temp += dna[j].charAt(y);
            }
            if ( temp.length() > 3) contSecOblInv += busquedaHorizontal(temp);
        }

        return contSecOblInv;
    }

}
