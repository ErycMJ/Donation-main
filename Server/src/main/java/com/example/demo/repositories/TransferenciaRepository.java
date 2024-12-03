package com.example.demo.repositories;

import com.example.demo.models.TransferenciaModelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransferenciaRepository extends JpaRepository<TransferenciaModelo, UUID> {

    List<TransferenciaModelo> findByRemetenteId(UUID remetenteId);

    List<TransferenciaModelo> findByDestinatarioId(UUID destinatarioId);

    List<TransferenciaModelo> findByRemetenteIdOrDestinatarioId(UUID remetenteId, UUID destinatarioId);
}
