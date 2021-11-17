package com.erParcial.apirestmutant.entities;

import java.util.regex.*;

public class SearchMutant {

    public SearchMutant() {

    }

    public Mutant buscarMutante(String[] dna) throws Exception {
        String result = "humano";
        if (verificarDNA(dna)) {
            SearchMutant searchMutant = new SearchMutant();
            try {
                int contSecuencia = 0;
                int size1 = dna.length - 1;
                int size2 = dna.length;

                for (int i = 0; i < dna.length; i++) {
                    contSecuencia = busquedaHorizontal(dna[i], contSecuencia);
                    if (contSecuencia > 1) break;
                    contSecuencia = busquedaVertical(dna, i, contSecuencia);
                    if (contSecuencia > 1) break;
                    contSecuencia = busquedaOblicua(dna, i, size1, size2, contSecuencia);
                    if (contSecuencia > 1) break;
                    size1--;
                    size2++;
                }
                if (contSecuencia < 2 ) contSecuencia = busquedaOblicuaInv(dna, contSecuencia);
                if (contSecuencia > 1) result = "mutante";
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        } else {
               result = "dna incorrecto";
        }

        Mutant mutant = new Mutant(dna, result);
        return mutant;
    }

    public int busquedaHorizontal(String fila, int contSecuencia) {
        for (int j = 3; j < fila.length(); j++) {
        	if ( compararDna(fila.charAt(j), fila.charAt(j-3), fila.charAt(j-2), fila.charAt(j-1)) ) {
        		contSecuencia++;
                break;
        	}
        }
        return contSecuencia;
    }

    public int busquedaVertical(String[] dna, int i, int contSecuencia) {
        for (int k = 3; k < dna.length; k++) {
        	if ( compararDna(dna[k].charAt(i), dna[k-3].charAt(i), dna[k-2].charAt(i), dna[k-1].charAt(i)) ) {
        		contSecuencia++;
                break;
        	}
        }
        return contSecuencia;
    }
    
    public boolean compararDna(char a, char b, char c, char d) {
    	boolean result = false;
    	if (a == b) {
    		if ( c == d && c == a) {
    			result = true;
    		}
    	}
    	return result;
    }

    public int busquedaOblicua(String[] dna, int i, int size1, int size2, int contSecuencia) {
        String filaTemp = "";
        for ( int j = 0, x = dna.length-1-i; j < dna.length-i; j++, x--){
            if((j+x) == size1) filaTemp += dna[x].charAt(j);
        }
        if ( filaTemp.length() > 3) contSecuencia = busquedaHorizontal(filaTemp, contSecuencia);
        filaTemp = "";
        for ( int j = i+1, x = dna.length-1; j < dna.length; j++, x--) {
            if ((j+x)== size2) filaTemp += dna[x].charAt(j);
        }
        if ( filaTemp.length() > 3) contSecuencia = busquedaHorizontal(filaTemp, contSecuencia);

        return contSecuencia;
    }

    public int busquedaOblicuaInv(String[] dna, int contSecuencia) {
        for ( int i = dna.length - 1; i > 0; i--) {
            String filaTemp = "";
            for (int j = 0, x = i; x <= dna.length - 1; j++, x++) {
                filaTemp += dna[x].charAt(j);
            }
            if ( filaTemp.length() > 3) contSecuencia = busquedaHorizontal(filaTemp, contSecuencia);
            if (contSecuencia > 1) break;
        }

        for ( int i = 0; i <= dna.length - 1; i++) {
            if (contSecuencia > 1) break;
            String filaTemp = "";
            for (int j = 0, y = i; y <= dna.length - 1; j++, y++ ) {
                filaTemp += dna[j].charAt(y);
            }
            if ( filaTemp.length() > 3) contSecuencia = busquedaHorizontal(filaTemp, contSecuencia);
        }
        return contSecuencia;
    }

    public boolean verificarDNA(String[] dna) {
        boolean result = true;
        for (String s: dna) {
            if (!s.matches("^[ATCG]+$")) {
                result = false;
            }
        }
        return result;
    }

}
