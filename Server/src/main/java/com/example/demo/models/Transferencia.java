package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "usuario_origem_id", nullable = false)
    private UsuarioModelo origem;

    @ManyToOne
    @JoinColumn(name = "usuario_destino_id", nullable = false)
    private UsuarioModelo destino;

    @ManyToOne
    @JoinColumn(name = "doacao_id", nullable = false)
    private DoacaoModelo doacao;

    private Double valor;

    private LocalDateTime dataTransferencia;

    public Transferencia() {
        this.dataTransferencia = LocalDateTime.now();
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UsuarioModelo getOrigem() {
        return origem;
    }

    public void setOrigem(UsuarioModelo origem) {
        this.origem = origem;
    }

    public UsuarioModelo getDestino() {
        return destino;
    }

    public void setDestino(UsuarioModelo destino) {
        this.destino = destino;
    }

    public DoacaoModelo getDoacao() {
        return doacao;
    }

    public void setDoacao(DoacaoModelo doacao) {
        this.doacao = doacao;
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
