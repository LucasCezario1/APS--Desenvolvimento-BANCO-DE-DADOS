package com.example.desenvolvimento.domain.application.controller;


import com.example.desenvolvimento.domain.model.Gerente;
import com.example.desenvolvimento.domain.service.GerenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/empresa")
@AllArgsConstructor
public class GerenteController {

    private  GerenteService gerenteService;

    @PostMapping("/gerente")
    public ResponseEntity saveGerente(@RequestBody @Validated Gerente gerente) {
       return ResponseEntity.ok(gerenteService.saveGerente(gerente));
    }

    @GetMapping("/gerente")
    public ResponseEntity<List<Gerente>> getAllGerentes() {
        return ResponseEntity.ok(gerenteService.ListarGerente());
    }

    @GetMapping("/gerente/{id}")
    public ResponseEntity getGerenteById(@PathVariable("id") Long idGerente) {
        return ResponseEntity.ok(gerenteService.ListarGestorByid(idGerente));
    }

    @PutMapping("/gerente/{id}")
    public ResponseEntity updateGerente(@RequestBody Gerente gerente, @PathVariable("id") Long idGerente) {
        Optional<Gerente> currentGerente = gerenteService.ListarGestorByid(idGerente);
        return ok(gerenteService.update(currentGerente, gerente));

    }

    @DeleteMapping("/gerente/{id}")
    public ResponseEntity deleteGerenteById(@PathVariable("id") Long idGerente) {
        gerenteService.deleteGerenteById(idGerente);
        return ResponseEntity.ok().build();
    }
}
