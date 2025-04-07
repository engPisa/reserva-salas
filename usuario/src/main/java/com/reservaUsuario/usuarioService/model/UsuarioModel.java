package com.reservaUsuario.usuarioService.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Table(name="Usuario")
@Entity(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded // Incorporando 'UsuárioData' como objeto agregado
    private UsuarioData usuarioData;

    @Embedded // Incorporando 'Endereço' como objeto agregado
    private Endereco endereco;

    private String senha;
    private String telefone;

    //Construtor Object root
    public UsuarioModel(UsuarioData usuarioData,
                        Endereco endereco,
                        String senha,
                        String telefone) {
        if (senha == null || senha.length() < 6) {
            throw  new IllegalArgumentException("A senha deve ter pelo menos 6 caracteres!");
        }
        if(telefone == null || telefone.trim().isEmpty()){
            throw new IllegalArgumentException("O telefone é obrigatorio!");
        }

        this.usuarioData = usuarioData;
        this.endereco = endereco;
        this.senha = encryptPassword(senha);
        this.telefone = formatTelefone(telefone);
    }

    private String encryptPassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
    private String formatTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Telefone invalido!");
        }
        telefone = telefone.replaceAll("[^0-9]","");
        return telefone.length() == 11 ? "55" + telefone : "55" + "9" + telefone;
    }
}
