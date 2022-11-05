package com.example.desenvolvimento.infrastructure.repository;

import com.example.desenvolvimento.domain.model.Analista;
import com.example.desenvolvimento.domain.model.dto.AnalistaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AnalistaRepository extends JpaRepository<Analista, Long> {

}
