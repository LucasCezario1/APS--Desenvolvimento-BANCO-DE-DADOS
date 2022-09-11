package com.example.desenvolvimento.domain.service.impl;

import com.example.desenvolvimento.domain.model.Analista;
import com.example.desenvolvimento.domain.service.AnalistaService;
import com.example.desenvolvimento.infrastructure.repository.AnalistaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AnalistaServiceImpl implements AnalistaService {


    private AnalistaRepository analistaRepository;

    @Override
    public Analista saveAnalista(Analista analista) {

        return analistaRepository.save(analista);
    }

    @Override
    public Optional<Analista> ListarAnalistaByid(Long idAnalista) {
        return analistaRepository.findById(idAnalista);
    }

    @Override
    public List<Analista> ListarAnalista() {
        return  analistaRepository.findAll();
    }

    @Override
    public Analista update(Optional<Analista> currentAnalista, Analista analista) {
        analista.setIdAnalistas(currentAnalista.get().getIdAnalistas());
        return analistaRepository.save(analista);
    }


    @Override
    @Transactional
    public void deleteAnalistaById(Long idAnalista) {
        analistaRepository.deleteById(idAnalista);
    }
}
