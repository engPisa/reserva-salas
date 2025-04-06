package com.reserva.reservaService.services;

import com.reserva.reservaService.DTO.ReservaRequestDTO;
import com.reserva.reservaService.DTO.ReservaResponseDTO;
import com.reserva.reservaService.model.ReservaModel;
import com.reserva.reservaService.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Transactional
    public ReservaResponseDTO cadastrarReserva(ReservaRequestDTO dto) {
        if (reservaRepository.salaOcupada(dto.salaId(), dto.dataHora())){
            throw new IllegalArgumentException("Ja existe uma reserva nesse horario.");
        }

        ReservaModel reserva = new ReservaModel();
        reserva.setSalaId(dto.salaId());
        reserva.setDataHora(dto.dataHora());
        reserva.setUsuarioId(dto.usuarioId());

        reserva = reservaRepository.save(reserva);

        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getDataHora(),
                reserva.getSalaId(),
                reserva.getUsuarioId()
        );
    }

}

