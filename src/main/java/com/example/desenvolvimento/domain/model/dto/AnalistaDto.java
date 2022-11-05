package com.example.desenvolvimento.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AnalistaDto {
    private Long idAnalistas;
    private String Cargo;
    private String Nome;
    private Long idEquipe;
}
