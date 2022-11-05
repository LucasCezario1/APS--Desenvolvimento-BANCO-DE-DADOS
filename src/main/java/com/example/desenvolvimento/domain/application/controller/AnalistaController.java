package com.example.desenvolvimento.domain.application.controller;

import com.example.desenvolvimento.domain.model.Analista;
import com.example.desenvolvimento.domain.service.AnalistaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/empresa")
@AllArgsConstructor
public class AnalistaController {
    private AnalistaService analistaService;

    @PostMapping("/analista")
    public ResponseEntity saveAnalistta(@RequestBody @Validated Analista analista) {
        if (Objects.isNull(analista.getEquipe())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ok(analistaService.saveAnalista(analista));
    }

    @GetMapping("/analista")
    public ResponseEntity<List<Analista>> getAllAnalistas() {
        return ok(analistaService.ListarAnalista());
    }

    @GetMapping("/analista/{id}")
    public ResponseEntity getAnalistaById(@PathVariable("id") Long idAnalistas) {
        return ok(analistaService.ListarAnalistaByid(idAnalistas));
    }


    @PutMapping("/analista/{id}")
    public ResponseEntity updateAnalista(@RequestBody Analista analista, @PathVariable("id") Long idAnalistas) {
        Optional<Analista> currentAnalista = analistaService.ListarAnalistaByid(idAnalistas);
        return ok(analistaService.update(currentAnalista, analista));

    }


    @DeleteMapping("/analista/{id}")
    public ResponseEntity deleteGerenteById(@PathVariable("id") Long idAnalistas) {
        analistaService.deleteAnalistaById(idAnalistas);
        return ok().build();
    }
}
