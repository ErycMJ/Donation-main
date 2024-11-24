package com.example.demo.mappers;

import com.example.demo.dtos.UsuarioRespostaDto;
import com.example.demo.models.UsuarioModelo;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioRespostaDto toDto(UsuarioModelo usuario) {
        return new UsuarioRespostaDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
