package com.example.demo.services;

import com.example.demo.dtos.DoacaoRequisicaoDto;
import com.example.demo.dtos.DoacaoRespostaDto;
import com.example.demo.models.DoacaoModelo;
import com.example.demo.models.UsuarioModelo;
import com.example.demo.repositories.DoacaoRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoacaoService {

    private final DoacaoRepository doacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public DoacaoService(DoacaoRepository doacaoRepository, UsuarioRepository usuarioRepository) {
        this.doacaoRepository = doacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<DoacaoRespostaDto> listarTodas() {
        return doacaoRepository.findAll().stream().map(this::toDto).toList();
    }

    public List<DoacaoRespostaDto> listarPorUsuario(UUID usuarioId) {
        return doacaoRepository.findByUsuarioCriadorId(usuarioId).stream().map(this::toDto).toList();
    }

    public DoacaoRespostaDto criar(DoacaoRequisicaoDto dto) {
        UsuarioModelo usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        DoacaoModelo doacao = new DoacaoModelo();
        doacao.setTitulo(dto.titulo());
        doacao.setDescricao(dto.descricao());
        doacao.setLocalizacao(dto.localizacao());
        doacao.setEmpresa(dto.empresa());
        doacao.setTempo(dto.tempo());
        doacao.setValor(dto.valor());
        doacao.setUsuarioCriador(usuario);

        return toDto(doacaoRepository.save(doacao));
    }

    public DoacaoRespostaDto 
    atualizar(UUID id, DoacaoRequisicaoDto dto) {
        DoacaoModelo doacao = doacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doação não encontrada"));

        doacao.setTitulo(dto.titulo());
        doacao.setDescricao(dto.descricao());
        doacao.setLocalizacao(dto.localizacao());
        doacao.setEmpresa(dto.empresa());
        doacao.setTempo(dto.tempo());
        doacao.setValor(dto.valor());

        return toDto(doacaoRepository.save(doacao));
    }

    public void deletar(UUID id) {
        DoacaoModelo doacao = doacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doação não encontrada"));
        doacaoRepository.delete(doacao);
    }

    private DoacaoRespostaDto toDto(DoacaoModelo doacao) {
        return new DoacaoRespostaDto(
                doacao.getId(),
                doacao.getTitulo(),
                doacao.getDescricao(),
                doacao.getLocalizacao(),
                doacao.getEmpresa(),
                doacao.getTempo(),
                doacao.getValor(),
                doacao.getUsuarioCriador().getId()
        );
    }
}