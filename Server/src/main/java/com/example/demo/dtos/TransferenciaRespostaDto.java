package com.example.demo.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record TransferenciaRespostaDto(
        UUID id,
        BigDecimal valor,
        UUID remetenteId,
        UUID destinatarioId
) {}
