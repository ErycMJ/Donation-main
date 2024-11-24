package com.example.demo.repositories;

import com.example.demo.models.DoacaoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DoacaoRepository extends JpaRepository<DoacaoModelo, UUID> {

    List<DoacaoModelo> findByUsuarioCriadorId(UUID usuarioId);
}