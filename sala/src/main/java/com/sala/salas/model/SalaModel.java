package com.sala.salas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Sala")
@Table(name="Sala")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String localizacao;
    private int capacidade;
}
