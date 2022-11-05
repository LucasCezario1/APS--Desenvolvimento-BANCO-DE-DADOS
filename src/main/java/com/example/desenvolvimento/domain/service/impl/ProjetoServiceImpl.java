package com.example.desenvolvimento.domain.service.impl;

import com.example.desenvolvimento.domain.model.Gerente;
import com.example.desenvolvimento.domain.model.Projeto;
import com.example.desenvolvimento.domain.service.GerenteService;
import com.example.desenvolvimento.domain.service.ProjetoService;
import com.example.desenvolvimento.infrastructure.repository.GerenteRepository;
import com.example.desenvolvimento.infrastructure.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {

    private ProjetoRepository projetoRepository;
    @Override
    public Projeto saveProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    public List<Projeto> ListarProjeto() {
        return projetoRepository.findAll();
    }

    @Override
    public Optional<Projeto> ListarProjetoByid(Long idProjeto) {
        return projetoRepository.findById(idProjeto);
    }

    @Override
    public Projeto update(Optional<Projeto> currentGerente, Projeto projeto) {
        projeto.setIdProjeto(currentGerente.get().getIdProjeto());
        return projetoRepository.save(projeto);
    }


    @Override
    @Transactional
    public void deleteProjetoById(Long idProjeto) {
        projetoRepository.deleteById(idProjeto);
    }
}
