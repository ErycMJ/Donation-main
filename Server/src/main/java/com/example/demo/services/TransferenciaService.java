package com.example.demo.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.TransferenciaResponseDTO;
import com.example.demo.mappers.TransferenciaMapper;
import com.example.demo.models.DoacaoModelo;
import com.example.demo.models.Transferencia;
import com.example.demo.models.UsuarioModelo;
import com.example.demo.repositories.DoacaoRepository;
import com.example.demo.repositories.TransferenciaRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class TransferenciaService {
    private final TransferenciaRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final DoacaoRepository doacaoRepository;

    public TransferenciaService(TransferenciaRepository repository, UsuarioRepository usuarioRepository, DoacaoRepository doacaoRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.doacaoRepository = doacaoRepository;
    }

    public TransferenciaResponseDTO realizarTransferencia(UUID doacaoId, UUID usuarioOrigemId, Double valor) {
        // Verificar se a doação existe
        DoacaoModelo doacao = doacaoRepository.findById(doacaoId)
                .orElseThrow(() -> new RuntimeException("Doação não encontrada"));

        // Verificar se o usuário de origem existe
        UsuarioModelo usuarioOrigem = usuarioRepository.findById(usuarioOrigemId)
                .orElseThrow(() -> new RuntimeException("Usuário origem não encontrado"));

        // Verificar se o usuário destino existe
        UsuarioModelo usuarioDestino = doacao.getUsuarioCriador();

        // Criar a transferência
        Transferencia transferencia = new Transferencia();
        transferencia.setOrigem(usuarioOrigem);
        transferencia.setDestino(usuarioDestino);
        transferencia.setDoacao(doacao);
        transferencia.setValor(valor);
        repository.save(transferencia);

        return TransferenciaMapper.toResponseDTO(transferencia);
    }
}
