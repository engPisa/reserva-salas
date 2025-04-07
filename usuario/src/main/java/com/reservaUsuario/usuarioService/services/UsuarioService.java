package com.reservaUsuario.usuarioService.services;

import com.reservaUsuario.usuarioService.DTO.UsuarioRequestDTO;
import com.reservaUsuario.usuarioService.DTO.UsuarioResponseDTO;
import com.reservaUsuario.usuarioService.exception.NotFoundException;
import com.reservaUsuario.usuarioService.model.Endereco;
import com.reservaUsuario.usuarioService.model.UsuarioData;
import com.reservaUsuario.usuarioService.model.UsuarioModel;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.reservaUsuario.usuarioService.repository.RepositoryUsuario;

@Service
public class UsuarioService {

  private final RepositoryUsuario repositoryUsuario;
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public UsuarioService(RepositoryUsuario repositoryUsuario){
    this.repositoryUsuario = repositoryUsuario;
  }

  public UsuarioResponseDTO buscarPorId(Long id){
    UsuarioModel usuarioModel = repositoryUsuario.findById(id)
            .orElseThrow(() -> new NotFoundException("Usuário com ID " + id + " não encontrado"));

    return toResponseDTO(usuarioModel);
  }

  @Transactional
  public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto){
    if(repositoryUsuario.existsByCpf(dto.cpf())){
      throw new IllegalArgumentException("Já existe um usuário com este CPF!");
    }

    UsuarioData usuarioData = new UsuarioData(
            dto.nome(), dto.cpf(), dto.email(), dto.dataNascimento());
    Endereco endereco = new Endereco(
            dto.rua(), dto.numero(), dto.cidade(), dto.estado(), dto.cep());

    String senhaCriptografada = passwordEncoder.encode(dto.senha());

    UsuarioModel usuarioModel = new UsuarioModel(
            usuarioData, endereco, senhaCriptografada, dto.telefone());

    usuarioModel = repositoryUsuario.save(usuarioModel);

    return toResponseDTO(usuarioModel);
  }

  private UsuarioResponseDTO toResponseDTO(UsuarioModel usuarioModel) {
    return new UsuarioResponseDTO(
            usuarioModel.getId(),
            usuarioModel.getUsuarioData().getNome(),
            usuarioModel.getUsuarioData().getCpf(),
            usuarioModel.getUsuarioData().getEmail(),
            usuarioModel.getUsuarioData().getDataNascimento(),
            usuarioModel.getUsuarioData().getDataCadastro(),
            usuarioModel.getTelefone(),
            usuarioModel.getEndereco().getRua(),
            usuarioModel.getEndereco().getCidade(),
            usuarioModel.getEndereco().getEstado(),
            usuarioModel.getEndereco().getNumero(),
            usuarioModel.getEndereco().getCep()
    );
  }
}
