package com.reservaUsuario.usuarioService.model;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable // Define como objeto de valor e não com entidade
@Getter
@NoArgsConstructor(force = true)
public class UsuarioData {
  private final String nome;
  private final String cpf;
  private final String email;
  private final LocalDate dataNascimento;
  private final LocalDate dataCadastro;

  //Construtor Value Objects
  public UsuarioData(String nome, String cpf, 
                     String email, 
                     LocalDate dataNascimento){

    if (nome == null || nome.trim().length() < 3){
      throw new IllegalArgumentException(
        "O nome deve ter pelo menos 3 caracteres.");
    }                  
    if (cpf == null || !cpf.matches("\\d{11}")){
      throw new IllegalArgumentException("CPF inválido.");
    }
    if (email == null || !email.contains("@")){
      throw new IllegalArgumentException("e-mail inválido."); 
    }
    if (dataNascimento == null) {
      throw new IllegalArgumentException(
        "Necessário informar uma data de nascimento."); 
    }
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.dataNascimento = dataNascimento;
    this.dataCadastro = LocalDate.now();
  }
}
