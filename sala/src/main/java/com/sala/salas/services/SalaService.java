package com.sala.salas.services;

import com.sala.salas.DTO.SalaRequestDTO;
import com.sala.salas.DTO.SalaResponseDTO;
import com.sala.salas.exceptions.SalaNotFoundException;
import com.sala.salas.model.SalaModel;
import com.sala.salas.repository.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    // Listar todas as salas
    public List<SalaResponseDTO> listarSalas() {
        return salaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Buscar sala por ID
    public SalaResponseDTO buscarPorId(Long id) {
        SalaModel sala = salaRepository.findById(id)
                .orElseThrow(() -> new SalaNotFoundException("Sala com ID " + id + " não encontrada."));
        return toResponseDTO(sala);
    }

    // Cadastrar nova sala
    @Transactional
    public SalaResponseDTO cadastraSala(SalaRequestDTO dto) {
        if (salaRepository.existsNome(dto.nome(), dto.localizacao())) {
            throw new IllegalArgumentException("Já existe uma sala com esse nome e localização.");
        }

        SalaModel sala = new SalaModel();
        sala.setNome(dto.nome());
        sala.setLocalizacao(dto.localizacao());
        sala.setCapacidade(dto.capacidade());

        SalaModel saved = salaRepository.save(sala);
        return toResponseDTO(saved);
    }

    // Atualizar sala
    @Transactional
    public SalaResponseDTO atualizarSala(Long id, SalaRequestDTO dto) {
        SalaModel sala = salaRepository.findById(id)
                .orElseThrow(() -> new SalaNotFoundException("Sala com ID " + id + " não encontrada."));

        if (salaRepository.existsNome(dto.nome(), dto.localizacao())) {
            throw new IllegalArgumentException("Já existe uma sala com esse nome e localização.");
        }

        BeanUtils.copyProperties(dto, sala, "id");
        return toResponseDTO(salaRepository.save(sala));
    }

    // Deletar sala
    @Transactional
    public void deletarSala(Long id) {
        SalaModel sala = salaRepository.findById(id)
                .orElseThrow(() -> new SalaNotFoundException("Sala com ID " + id + " não encontrada."));
        salaRepository.delete(sala);
    }

    // Converter para ResponseDTO
    private SalaResponseDTO toResponseDTO(SalaModel sala) {
        return new SalaResponseDTO(
                sala.getId(),
                sala.getNome(),
                sala.getLocalizacao(),
                sala.getCapacidade()
        );
    }
}
