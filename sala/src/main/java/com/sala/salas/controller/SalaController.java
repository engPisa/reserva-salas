package com.sala.salas.controller;

import com.sala.salas.DTO.SalaRequestDTO;
import com.sala.salas.DTO.SalaResponseDTO;
import com.sala.salas.services.SalaService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva-sala/sala")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    //Lista todas as salas
    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> listarTodasSalas() {
        List<SalaResponseDTO> salas = salaService.listarSalas();
        return ResponseEntity.ok(salas);
    }

    //Busca sala por ID
    public ResponseEntity<SalaResponseDTO> buscarSalaPorId(@PathVariable Long id) {
        SalaResponseDTO sala = salaService.buscarPorId(id);
        return ResponseEntity.ok(sala);
    }

    //Cadastrar nova sala
    @PostMapping
    public ResponseEntity<SalaResponseDTO>cadastrar(@RequestBody SalaRequestDTO dto) {
        SalaResponseDTO response = salaService.cadastraSala(dto);
        return ResponseEntity.ok(response);
    }

    //Atualizar sala existente
    @PutMapping("/{id}")
    public  ResponseEntity<SalaResponseDTO> atualizarSala(@PathVariable Long id, @RequestBody SalaRequestDTO dto) {
        SalaResponseDTO salaAtualizada = salaService.atualizarSala(id, dto);
        return ResponseEntity.ok(salaAtualizada);
    }

    //Deletar Sala
    @DeleteMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> deletarSala(@PathVariable Long id) {
        salaService.deletarSala(id);
        return ResponseEntity.noContent().build();
    }
}
