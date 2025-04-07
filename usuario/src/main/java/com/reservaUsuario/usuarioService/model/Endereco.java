package com.reservaUsuario.usuarioService.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable // Define como objeto de valor e não com entidade
@Getter
@NoArgsConstructor(force = true)
public class Endereco {
  private final String rua;
  private final String numero;
  private final String cidade;
  private final String estado;
  private final String cep;

  //Construtor Value Objects
  public Endereco(String rua, String numero, String cidade, String estado, String cep){
    this.rua = rua;
    this.numero = numero;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  @Override
  public String toString() {
    return rua + ", " + numero + ", " + cidade + " - " + cep;
  }
}
