package com.reservaUsuario.usuarioService.controller;

import com.reservaUsuario.usuarioService.DTO.UsuarioRequestDTO;
import com.reservaUsuario.usuarioService.DTO.UsuarioResponseDTO;
import com.reservaUsuario.usuarioService.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva-sala/usuário")
public class UsuarioController {

  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
    UsuarioResponseDTO responseDTO = usuarioService.buscarPorId(id);
    return ResponseEntity.ok(responseDTO);
  }

  @PostMapping
  public ResponseEntity<UsuarioResponseDTO> criarUsuario(
          @RequestBody UsuarioRequestDTO  usuarioRequestDTO){
    UsuarioResponseDTO responseDTO = usuarioService.cadastrarUsuario(usuarioRequestDTO);
    return ResponseEntity.ok(responseDTO);
  }
  
}
