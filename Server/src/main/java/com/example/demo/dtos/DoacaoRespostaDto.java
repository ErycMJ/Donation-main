package com.example.demo.dtos;

import java.util.UUID;

public record DoacaoRespostaDto(
        UUID id,
        String titulo,
        String descricao,
        String localizacao,
        String empresa,
        String tempo,
        Double valor,
        com.example.demo.models.UsuarioModelo usuarioId
) {}