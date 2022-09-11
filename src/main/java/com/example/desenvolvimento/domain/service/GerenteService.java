package com.example.desenvolvimento.domain.service;

import com.example.desenvolvimento.domain.model.Analista;
import com.example.desenvolvimento.domain.model.Gerente;

import java.util.List;
import java.util.Optional;

public interface GerenteService {

    // Salva Gerente no Banco de dados
    Gerente saveGerente(Gerente gerente);

    // Lista Todos os Gerente que estao no Banco de dados
    List<Gerente> ListarGerente();

    Optional<Gerente> ListarGestorByid(Long idGerente);

    // Atualiza lista Gerente pelo id no Banco de dados

    Gerente update(Optional<Gerente> currentGerente, Gerente gerente);

    // Deleta Gerente pelo id
    void deleteGerenteById(Long idGerente);

}
