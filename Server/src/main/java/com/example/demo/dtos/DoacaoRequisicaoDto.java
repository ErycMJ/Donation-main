package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record DoacaoRequisicaoDto(        
        @NotBlank String titulo,
        @NotBlank String descricao,
        @NotBlank String localizacao,
        @NotBlank String empresa,
        @NotBlank String imagem,
        @NotBlank String tempo,
        @NotNull Double valor,
        @NotNull UUID usuarioId
) {
}