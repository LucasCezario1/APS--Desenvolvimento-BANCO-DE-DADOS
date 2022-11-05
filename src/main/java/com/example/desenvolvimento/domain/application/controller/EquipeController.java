package com.example.desenvolvimento.domain.application.controller;


import com.example.desenvolvimento.domain.model.Equipe;
import com.example.desenvolvimento.domain.model.Gerente;
import com.example.desenvolvimento.domain.service.EquipeService;
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
public class EquipeController {

    private EquipeService equipeService;

    @PostMapping("/equipe")
    public ResponseEntity saveEquipe(@RequestBody @Validated Equipe equipe) {
       return ResponseEntity.ok(equipeService.saveEquipe(equipe));
    }

    @GetMapping("/equipe")
    public ResponseEntity<List<Equipe>> getAllEquipe() {
        return ResponseEntity.ok(equipeService.ListarEquipe());
    }

    @GetMapping("/equipe/{id}")
    public ResponseEntity getEquipeById(@PathVariable("id") Long idEquipe) {
        return ResponseEntity.ok(equipeService.ListarEquipeByid(idEquipe));
    }

    @PutMapping("/equipe/{id}")
    public ResponseEntity updateEquipe(@RequestBody Equipe equipe, @PathVariable("id") Long idEquipe) {
        Optional<Equipe> currentGerente = equipeService.ListarEquipeByid(idEquipe);
        return ok(equipeService.update(currentGerente, equipe));

    }

    @DeleteMapping("/equipe/{id}")
    public ResponseEntity deleteEquipeById(@PathVariable("id") Long idEquipe) {
        equipeService.deleteEquipeById(idEquipe);
        return ResponseEntity.ok().build();
    }
}
