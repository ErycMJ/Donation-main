package com.example.demo.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class GrupoModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;

    public GrupoModelo() {

    }

    public GrupoModelo(String nome){
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
