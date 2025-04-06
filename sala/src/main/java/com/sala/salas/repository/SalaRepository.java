package com.sala.salas.repository;

import com.sala.salas.model.SalaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<SalaModel, Long> {
    boolean existsNome(String nome, String localizacao);
}
