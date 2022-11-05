package com.example.desenvolvimento.domain.service;

import com.example.desenvolvimento.domain.model.Analista;
import com.example.desenvolvimento.domain.model.Equipe;

import java.util.List;
import java.util.Optional;

public interface EquipeService {

    // Salva equipe no Banco de dados
    Equipe saveEquipe(Equipe equipe);


    // Lista equipe pelo id
    Optional<Equipe> ListarEquipeByid(Long idEquipe);

    // Lista Todos os equipes que estao no Banco de dados
    List<Equipe> ListarEquipe();

    // Atualiza lista equipe pelo id no Banco de dados
    Equipe update(Optional<Equipe> currentEquipe, Equipe equipe);


    // Deleta Analaista pelo id
    void deleteEquipeById(Long idEquipe);



}
