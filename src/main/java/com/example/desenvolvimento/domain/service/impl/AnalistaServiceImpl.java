package com.example.desenvolvimento.domain.service.impl;

import com.example.desenvolvimento.domain.model.Analista;
import com.example.desenvolvimento.domain.model.Equipe;
import com.example.desenvolvimento.domain.model.dto.AnalistaDto;
import com.example.desenvolvimento.domain.service.AnalistaService;
import com.example.desenvolvimento.infrastructure.repository.AnalistaRepository;
import com.example.desenvolvimento.infrastructure.repository.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AnalistaServiceImpl implements AnalistaService {


    private AnalistaRepository analistaRepository;

    private EquipeRepository equipeRepository;

    @Override
    public Analista saveAnalista(AnalistaDto analistaDto) {
        Equipe equipe = equipeRepository.getById(analistaDto.getIdEquipe());

        Analista analista = Analista.builder()
                .idAnalistas(analistaDto.getIdAnalistas())
                .Nome(analistaDto.getNome())
                .Cargo(analistaDto.getCargo())
                .equipe(equipe)
                .build();



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
    public Analista update(Long idAnalista, AnalistaDto analistaDto) {
       // analistaDto.setIdAnalistas(currentAnalista.get().getIdAnalistas());

        Equipe equipe = equipeRepository.getById(analistaDto.getIdEquipe());

        Optional<Equipe> equipeOptional = equipeRepository.findById(idAnalista);

        if (!equipeOptional.isPresent()) {
            return null;
        }

      //  Sector sectorExistent = sectorOptional.get();


        return analistaRepository.save( Analista.builder()
                .idAnalistas(analistaDto.getIdAnalistas())
                .Nome(analistaDto.getNome())
                .Cargo(analistaDto.getCargo())
                .equipe(equipe)
                .build());
    }


    @Override
    @Transactional
    public void deleteAnalistaById(Long idAnalista) {
        analistaRepository.deleteById(idAnalista);
    }
}
