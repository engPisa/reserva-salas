package com.reserva.reservaService.client;

import com.reserva.reservaService.DTO.SalaResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="sala-service", url="http://localhost:8082")
public interface SalaClient {
    @GetMapping("/reserva-sala/sala/{id}")
    SalaResponseDTO buscarSalaPorId(@PathVariable("id") Long id);
}
