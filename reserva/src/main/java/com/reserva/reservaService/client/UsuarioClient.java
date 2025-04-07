package com.reserva.reservaService.client;

import com.reserva.reservaService.DTO.UsuarioResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="usuario-service", url="http://localhost:8081")
public interface UsuarioClient {
    @GetMapping("/reserva-sala/usuario/{id}")
    UsuarioResponseDTO buscarPorId(@PathVariable("id") Long id);
}
