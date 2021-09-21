package com.erParcial.apirestmutant.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ADN_VERIFICADOS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mutant extends Base {

    @Column(name = "dna")
    private String[] dna;

    @Column(name = "clasificacion", length = 7)
    private String clasificacion;
}
