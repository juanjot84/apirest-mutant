package com.erParcial.apirestmutant.controllers;

import com.erParcial.apirestmutant.entities.Mutant;
import com.erParcial.apirestmutant.entities.StastsDTO;
import com.erParcial.apirestmutant.services.MutantService;
import com.erParcial.apirestmutant.services.MutantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/mutant")
public class MutantController extends BaseControllerImp<Mutant, MutantServiceImpl>{

    @GetMapping("/stats")
    public ResponseEntity<?> getStasts() {
        try {
            StastsDTO stastsDTO = servicio.getStast();
            return ResponseEntity.status(HttpStatus.OK).body(stastsDTO);
            //"{\"count_mutant_dna\":\""+stastsDTO.getCountMutantDna()+"\",count_human_dna\":\""+stastsDTO.getCountHumanDna()+"\",ratio\":\""+stastsDTO.getRatio()+"}"
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> verificarDna(@RequestBody Mutant entity) {
        try {
            entity = servicio.isMutant(entity.getDna());
            entity = servicio.save(entity);
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
