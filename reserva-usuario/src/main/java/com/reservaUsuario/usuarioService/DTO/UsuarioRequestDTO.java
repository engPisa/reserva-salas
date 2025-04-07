package com.reservaUsuario.usuarioService.DTO;

import java.time.LocalDate;

public record UsuarioRequestDTO (
        String nome,
        String cpf,
        String email,
        String senha,
        LocalDate dataNascimento,
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep,
        String telefone
){}
