package com.example.demo.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class TransferenciaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "remetente_id")
    private UsuarioModelo remetente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "destinatario_id")
    private UsuarioModelo destinatario;

    private BigDecimal valor;
    private LocalDateTime dataTransferencia;

    public TransferenciaModelo() {}

    public TransferenciaModelo(UsuarioModelo remetente, UsuarioModelo destinatario, BigDecimal valor, LocalDateTime dataTransferencia) {
        this.remetente = remetente;
        this.destinatario = destinatario;
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

    public UsuarioModelo getRemetente() {
        return remetente;
    }

    public void setRemetente(UsuarioModelo remetente) {
        this.remetente = remetente;
    }

    public UsuarioModelo getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(UsuarioModelo destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }
}
