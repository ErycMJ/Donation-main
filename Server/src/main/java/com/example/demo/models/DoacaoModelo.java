package com.example.demo.models;

import com.example.demo.dtos.DoacaoDto;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class DoacaoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String titulo;
    private String descricao;
    private String localizacao;
    private String empresa;
    private String tempo;
    private Double valor;
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id")
    private UsuarioModelo usuarioCriador;

    public DoacaoModelo() {}

    public DoacaoModelo(String titulo, String descricao, String localizacao, String empresa, String tempo, Double valor, LocalDate data, UsuarioModelo usuarioCriador) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.empresa = empresa;
        this.tempo = tempo;
        this.valor = valor;
        this.data = data;
        this.usuarioCriador = usuarioCriador;
    }

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public UsuarioModelo getUsuarioCriador() {
        return usuarioCriador;
    }

    public void setUsuarioCriador(UsuarioModelo usuarioCriador) {
        this.usuarioCriador = usuarioCriador;
    }

    // Método para inicializar o modelo com dados de um DTO
    public static DoacaoModelo fromDto(DoacaoDto dto, UsuarioModelo usuario) {
        DoacaoModelo doacao = new DoacaoModelo();
        doacao.setTitulo(dto.getTitulo());
        doacao.setDescricao(dto.getDescricao());
        doacao.setLocalizacao(dto.getLocalizacao());
        doacao.setEmpresa(dto.getEmpresa());
        doacao.setTempo(dto.getTempo());
        doacao.setValor(dto.getValor());
        doacao.setUsuarioCriador(usuario);
        return doacao;
    }
}
