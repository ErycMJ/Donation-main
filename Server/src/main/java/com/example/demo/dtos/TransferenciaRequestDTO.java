package com.example.demo.dtos;

import java.util.UUID;

public class TransferenciaRequestDTO {
    private UUID doacaoId;
    private Double valor;

    // Getters e Setters
    public UUID getDoacaoId() {
        return doacaoId;
    }

    public void setDoacaoId(UUID doacaoId) {
        this.doacaoId = doacaoId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
