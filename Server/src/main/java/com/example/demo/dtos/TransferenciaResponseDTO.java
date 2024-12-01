package com.example.demo.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransferenciaResponseDTO {
    private UUID id; 
    private String origem;
    private String destino;
    private String doacaoTitulo;
    private Double valor;
    private LocalDateTime dataTransferencia;

    public TransferenciaResponseDTO(UUID id, String origem, String destino, String doacaoTitulo, Double valor, LocalDateTime dataTransferencia) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.doacaoTitulo = doacaoTitulo;
        this.valor = valor;
        this.dataTransferencia = dataTransferencia;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDoacaoTitulo() {
        return doacaoTitulo;
    }

    public void setDoacaoTitulo(String doacaoTitulo) {
        this.doacaoTitulo = doacaoTitulo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }
}
