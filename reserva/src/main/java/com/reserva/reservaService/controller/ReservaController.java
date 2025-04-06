package com.reserva.reservaService.controller;

import com.reserva.reservaService.DTO.ReservaRequestDTO;
import com.reserva.reservaService.DTO.ReservaResponseDTO;
import com.reserva.reservaService.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva-sala/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO>cadastrar(@RequestBody ReservaRequestDTO dto){
        ReservaResponseDTO responseDTO = reservaService.cadastrarReserva(dto);
        return ResponseEntity.ok(responseDTO);
    }

}
