package com.example.demo.dtos;

public class DoacaoDto {
    private String titulo;
    private String descricao;
    private String localizacao;
    private String empresa;
    private String tempo;
    private Double valor;

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getLocalizacao() { return localizacao; }
    public String getEmpresa() { return empresa; }
    public String getTempo() { return tempo; }
    public Double getValor() { return valor; }
}