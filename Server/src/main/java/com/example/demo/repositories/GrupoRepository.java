package com.example.demo.repositories;

import com.example.demo.models.GrupoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoModelo, UUID> {
    public Optional<GrupoModelo> findByNome(String nome);
}
