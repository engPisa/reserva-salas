package com.reservaUsuario.usuarioService.DTO;

import java.time.LocalDate;

public record UsuarioResponseDTO (
        Long id,
        String nome,
        String cpf,
        String email,
        LocalDate dataNascimento,
        LocalDate dataCadastro,
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep,
        String telefone
){}
