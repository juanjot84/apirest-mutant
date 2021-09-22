package com.erParcial.apirestmutant.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


@NoArgsConstructor
@Getter
@Setter
public class StastsDTO {

    private int count_mutant_dna;
    private int count_human_dna;
    private float ratio;

}
