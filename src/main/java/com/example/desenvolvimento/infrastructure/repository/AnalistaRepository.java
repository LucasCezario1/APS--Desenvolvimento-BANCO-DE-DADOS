package com.example.desenvolvimento.infrastructure.repository;

import com.example.desenvolvimento.domain.model.Analista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalistaRepository extends JpaRepository<Analista, Long> {

}
