package com.erParcial.apirestmutant.controllers;

import com.erParcial.apirestmutant.entities.Mutant;
import com.erParcial.apirestmutant.services.MutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/mutant")
public class MutantController {
    private MutantService mutantService;

    public MutantController(MutantService mutantService) {
        this.mutantService = mutantService;
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mutantService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> verificarDna(@RequestBody Mutant entity) {
        try {
            entity = mutantService.isMutant(entity.getDna());
            entity = mutantService.save(entity);
            if ( entity.getClasificacion() == "mutante" ) {
                return ResponseEntity.status(HttpStatus.OK).body("{\"Es Mutante.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Es Humano.\"}");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
