package com.example.desenvolvimento.infrastructure.repository;

import com.example.desenvolvimento.domain.model.Analista;
import com.example.desenvolvimento.domain.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
