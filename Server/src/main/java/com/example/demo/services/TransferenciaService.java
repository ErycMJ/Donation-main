package com.example.demo.services;

import com.example.demo.dtos.TransferenciaRequisicaoDto;
import com.example.demo.dtos.TransferenciaRespostaDto;
import com.example.demo.models.TransferenciaModelo;
import com.example.demo.models.UsuarioModelo;
import com.example.demo.repositories.TransferenciaRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final UsuarioRepository usuarioRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository, UsuarioRepository usuarioRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<TransferenciaRespostaDto> listarTodas() {
        return transferenciaRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public List<TransferenciaRespostaDto> listarPorRemetente(UUID remetenteId) {
        return transferenciaRepository.findByRemetenteId(remetenteId).stream()
                .map(this::toDto)
                .toList();
    }

    public List<TransferenciaRespostaDto> listarPorDestinatario(UUID destinatarioId) {
        return transferenciaRepository.findByDestinatarioId(destinatarioId).stream()
                .map(this::toDto)
                .toList();
    }

    public List<TransferenciaRespostaDto> listarPorUsuario(UUID usuarioId) {
        List<TransferenciaModelo> transferenciasRemetente = transferenciaRepository.findByRemetenteId(usuarioId);
        List<TransferenciaModelo> transferenciasDestinatario = transferenciaRepository.findByDestinatarioId(usuarioId);

        transferenciasRemetente.addAll(transferenciasDestinatario);

        return transferenciasRemetente.stream()
                .map(this::toDto)
                .toList();
    }

    public TransferenciaRespostaDto criar(TransferenciaRequisicaoDto dto) {
        UsuarioModelo remetente = usuarioRepository.findById(dto.remetenteId())
                .orElseThrow(() -> new RuntimeException("Remetente não encontrado"));

        UsuarioModelo destinatario = usuarioRepository.findById(dto.destinatarioId())
                .orElseThrow(() -> new RuntimeException("Destinatário não encontrado"));

        TransferenciaModelo transferencia = new TransferenciaModelo();
        transferencia.setValor(dto.valor());
        transferencia.setRemetente(remetente);
        transferencia.setDestinatario(destinatario);

        return toDto(transferenciaRepository.save(transferencia));
    }

    public TransferenciaRespostaDto atualizar(UUID id, TransferenciaRequisicaoDto dto) {
        TransferenciaModelo transferencia = transferenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transferência não encontrada"));

        UsuarioModelo remetente = usuarioRepository.findById(dto.remetenteId())
                .orElseThrow(() -> new RuntimeException("Remetente não encontrado"));

        UsuarioModelo destinatario = usuarioRepository.findById(dto.destinatarioId())
                .orElseThrow(() -> new RuntimeException("Destinatário não encontrado"));

        transferencia.setValor(dto.valor());
        transferencia.setRemetente(remetente);
        transferencia.setDestinatario(destinatario);

        return toDto(transferenciaRepository.save(transferencia));
    }

    public void deletar(UUID id) {
        TransferenciaModelo transferencia = transferenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transferência não encontrada"));
        transferenciaRepository.delete(transferencia);
    }

    private TransferenciaRespostaDto toDto(TransferenciaModelo transferencia) {
        return new TransferenciaRespostaDto(
                transferencia.getId(),
                BigDecimal.valueOf(transferencia.getValor()),   // Converte valor para BigDecimal
                transferencia.getRemetente().getId(),
                transferencia.getDestinatario().getId()
        );
    }
} 
