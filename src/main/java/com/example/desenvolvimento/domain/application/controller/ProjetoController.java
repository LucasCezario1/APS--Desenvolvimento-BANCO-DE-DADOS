package com.example.desenvolvimento.domain.application.controller;


import com.example.desenvolvimento.domain.model.Gerente;
import com.example.desenvolvimento.domain.model.Projeto;
import com.example.desenvolvimento.domain.service.GerenteService;
import com.example.desenvolvimento.domain.service.ProjetoService;
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
public class ProjetoController {

    private ProjetoService projetoService;

    @PostMapping("/projeto")
    public ResponseEntity saveProjeto(@RequestBody @Validated Projeto projeto) {
       return ResponseEntity.ok(projetoService.saveProjeto(projeto));
    }

    @GetMapping("/projeto")
    public ResponseEntity<List<Projeto>> getAllProjeto() {
        return ResponseEntity.ok(projetoService.ListarProjeto());
    }

    @GetMapping("/projeto/{id}")
    public ResponseEntity getProjetoById(@PathVariable("id") Long idProjeto) {
        return ResponseEntity.ok(projetoService.ListarProjetoByid(idProjeto));
    }

    @PutMapping("/projeto/{id}")
    public ResponseEntity updateProjeto(@RequestBody Projeto projeto, @PathVariable("id") Long idProjeto) {
        Optional<Projeto> currentProjeto = projetoService.ListarProjetoByid(idProjeto);
        return ok(projetoService.update(currentProjeto, projeto));

    }

    @DeleteMapping("/projeto/{id}")
    public ResponseEntity deleteProjetoById(@PathVariable("id") Long idProjeto) {
        projetoService.deleteProjetoById(idProjeto);
        return ResponseEntity.ok().build();
    }
}
