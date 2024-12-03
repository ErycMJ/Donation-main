package com.example.demo.dtos;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

public record TransferenciaRequisicaoDto(
        @NotNull UUID remetenteId,
        @NotNull UUID destinatarioId,
        @NotNull BigDecimal valor
) {
}
