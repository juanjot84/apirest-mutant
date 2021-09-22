package com.erParcial.apirestmutant.controllers;

import com.erParcial.apirestmutant.entities.Base;
import com.erParcial.apirestmutant.entities.Mutant;
import com.erParcial.apirestmutant.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class BaseControllerImp<E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {

    @Autowired
    protected S servicio;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long aLong) {
        return null;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(Mutant entity) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(Long aLong, Mutant entity) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }
}
