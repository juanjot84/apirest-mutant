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
public class StastsDTO extends Base{

    private int countMutantDna;
    private int countHumanDna;
    private long ratio;

}
