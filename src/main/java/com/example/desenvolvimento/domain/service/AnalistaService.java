package com.example.desenvolvimento.domain.service;

import com.example.desenvolvimento.domain.model.Analista;

import java.util.List;
import java.util.Optional;

public interface AnalistaService {

    // Salva Analista no Banco de dados
    Analista saveAnalista(Analista analista);


    // Lista Analista pelo id
    Optional<Analista> ListarAnalistaByid(Long idAnalistas);

    // Lista Todos os Analistas que estao no Banco de dados
    List<Analista> ListarAnalista();

    // Atualiza lista analista pelo id no Banco de dados
    Analista update(Optional<Analista> currentAnalista, Analista analista);


    // Deleta Analaista pelo id
    void deleteAnalistaById(Long idAnalistas);



}
