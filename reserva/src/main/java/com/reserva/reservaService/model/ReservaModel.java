package com.reserva.reservaService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="Reserva")
@Entity(name="Reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;

    private  Long salaId;
    private Long usuarioId;
}
