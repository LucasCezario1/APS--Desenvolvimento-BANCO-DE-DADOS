package com.example.desenvolvimento.domain.application.controller;

import com.example.desenvolvimento.domain.model.Analista;
import com.example.desenvolvimento.domain.model.dto.AnalistaDto;
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
    public ResponseEntity<Analista> saveAnalistta(@RequestBody @Validated AnalistaDto analistaDto) {
        return ok(analistaService.saveAnalista(analistaDto));
    }

    @GetMapping("/analista")
    public ResponseEntity<List<Analista>> getAllAnalistas() {
        return ok(analistaService.ListarAnalista());
    }

    @GetMapping("/analista/{id}")
    public ResponseEntity getAnalistaById(@PathVariable("id") Long idAnalistas) {
        return ok(analistaService.ListarAnalistaByid(idAnalistas));
    }


    @PutMapping("/analista/{idAnalista}")
    public ResponseEntity<Analista> updateAnalista( @PathVariable Long idAnalista, @RequestBody  AnalistaDto analistaDto) {
        return ResponseEntity.ok(analistaService.update(idAnalista, analistaDto));

    }


    @DeleteMapping("/analista/{id}")
    public ResponseEntity deleteGerenteById(@PathVariable("id") Long idAnalistas) {
        analistaService.deleteAnalistaById(idAnalistas);
        return ok().build();
    }
}
