package com.example.desenvolvimento.domain.service.impl;

import com.example.desenvolvimento.domain.model.Gerente;
import com.example.desenvolvimento.domain.service.GerenteService;
import com.example.desenvolvimento.infrastructure.repository.GerenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class GerenteServiceImpl implements GerenteService {

    private GerenteRepository gerenteRepository;
    @Override
    public Gerente saveGerente(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @Override
    public List<Gerente> ListarGerente() {
        return gerenteRepository.findAll();
    }

    @Override
    public Optional<Gerente> ListarGestorByid(Long idGerente) {
        return gerenteRepository.findById(idGerente);
    }

    @Override
    public Gerente update(Optional<Gerente> currentGerente, Gerente gerente) {
        gerente.setIdGerente(currentGerente.get().getIdGerente());
        return gerenteRepository.save(gerente);
    }


    @Override
    @Transactional
    public void deleteGerenteById(Long idGerente) {
        gerenteRepository.deleteById(idGerente);
    }
}
