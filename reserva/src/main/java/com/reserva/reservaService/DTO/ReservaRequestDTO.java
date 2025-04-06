package com.reserva.reservaService.DTO;

import java.time.LocalDateTime;

public record ReservaRequestDTO(
    LocalDateTime dataHora,
    Long salaId,
    Long usuarioId
){}
