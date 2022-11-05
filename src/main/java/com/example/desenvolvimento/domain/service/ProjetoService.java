package com.example.desenvolvimento.domain.service;

import com.example.desenvolvimento.domain.model.Analista;
import com.example.desenvolvimento.domain.model.Projeto;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    // Salva projeto no Banco de dados
    Projeto saveProjeto(Projeto projeto);


    // Lista Projeto pelo id
    Optional<Projeto> ListarProjetoByid(Long idProjeto);

    // Lista Todos os Projeto que estao no Banco de dados
    List<Projeto> ListarProjeto();

    // Atualiza lista Projeto pelo id no Banco de dados
    Projeto update(Optional<Projeto> currentProjeto, Projeto projeto);


    // Deleta Projeto pelo id
    void deleteProjetoById(Long idProjeto);



}
