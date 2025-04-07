package com.reserva.reservaService.DTO;

import java.time.LocalDateTime;

public record ReservaRequestDTO(
    Long id,
    LocalDateTime dataHora,
    Long salaId,
    Long usuarioId
){}
