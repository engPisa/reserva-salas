package com.reserva.reservaService.DTO;

import java.time.LocalDateTime;

public record ReservaResponseDTO (
        Long id,
        LocalDateTime dataHora,
        Long salaId,
        Long usuarioId
){}
