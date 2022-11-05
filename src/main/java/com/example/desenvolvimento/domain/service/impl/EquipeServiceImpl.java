package com.example.desenvolvimento.domain.service.impl;

import com.example.desenvolvimento.domain.model.Equipe;
import com.example.desenvolvimento.domain.model.Gerente;
import com.example.desenvolvimento.domain.service.EquipeService;
import com.example.desenvolvimento.domain.service.GerenteService;
import com.example.desenvolvimento.infrastructure.repository.EquipeRepository;
import com.example.desenvolvimento.infrastructure.repository.GerenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EquipeServiceImpl implements EquipeService {

    private EquipeRepository equipeRepository;
    @Override
    public Equipe saveEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }


    @Override
    public List<Equipe> ListarEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Optional<Equipe> ListarEquipeByid(Long idEquipe) {
        return equipeRepository.findById(idEquipe);
    }

    @Override
    public Equipe update(Optional<Equipe> currentGerente, Equipe equipe) {
        equipe.setIdEquipe(currentGerente.get().getIdEquipe());
        return equipeRepository.save(equipe);
    }


    @Override
    @Transactional
    public void deleteEquipeById(Long idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }
}
