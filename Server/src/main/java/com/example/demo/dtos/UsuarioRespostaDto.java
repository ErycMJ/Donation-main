package com.example.demo.dtos;

import java.util.UUID;

public record UsuarioRespostaDto(
        UUID id,
        String nome,
        String email
) {
}
