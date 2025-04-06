package com.sala.salas.DTO;

public record SalaResponseDTO (
        Long id,
        String nome,
        String localizacao,
        Integer capacidade
){}
