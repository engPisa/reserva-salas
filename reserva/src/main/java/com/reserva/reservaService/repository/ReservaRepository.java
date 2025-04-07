package com.reserva.reservaService.repository;

import com.reserva.reservaService.model.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel, Long> {
    boolean salaOcupada(Long salaId, LocalDateTime dataHora);
}
