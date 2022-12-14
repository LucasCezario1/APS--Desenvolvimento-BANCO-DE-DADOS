package com.example.desenvolvimento.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Analista {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnalistas;
    private String Cargo;
    private String Nome;
    private String Equipe;


}
