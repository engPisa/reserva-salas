package com.reserva.reservaService.DTO;

public record SalaResponseDTO(
    Long id,
    String nome,
    String localizacao,
    Integer capacidade
    ){}

