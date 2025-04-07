package com.reserva.reservaService.services;

import com.reserva.reservaService.DTO.ReservaRequestDTO;
import com.reserva.reservaService.DTO.ReservaResponseDTO;
import com.reserva.reservaService.client.SalaClient;
import com.reserva.reservaService.client.UsuarioClient;
import com.reserva.reservaService.exception.NotFoundException;
import com.reserva.reservaService.exception.SalaOcupadaException;
import com.reserva.reservaService.model.ReservaModel;
import com.reserva.reservaService.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioClient usuarioClient;
    private final SalaClient salaClient;

    public ReservaService(ReservaRepository reservaRepository,
                          UsuarioClient usuarioClient,
                          SalaClient salaClient) {
        this.reservaRepository = reservaRepository;
        this.usuarioClient = usuarioClient;
        this.salaClient = salaClient;
    }

    @Transactional
    public ReservaResponseDTO cadastrarReserva(ReservaRequestDTO dto) {

        //Valida usuário
        try {
            usuarioClient.buscarPorId(dto.usuarioId());
        } catch (Exception e) {
            throw new NotFoundException("Usuário com ID" + dto.usuarioId() + "não encontrado");
        }

        //Valida sala
        try{
            salaClient.buscarSalaPorId(dto.salaId());
        } catch (Exception e) {
            throw new NotFoundException("Sala com ID" + dto.salaId() + "não encontrada");
        }

        if (reservaRepository.existsBySalaIdAndDataInicio(dto.salaId(), dto.dataHora())){
            throw new SalaOcupadaException("Ja existe uma reserva nesse horario.");
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

