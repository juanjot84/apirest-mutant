package com.erParcial.apirestmutant.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StastsDTO {

    private int countMutantDna;
    private int countHumanDna;
    private float ratio;

}
