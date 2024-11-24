package com.example.demo.mappers;

import com.example.demo.dtos.DoacaoRequisicaoDto;
import com.example.demo.dtos.DoacaoRespostaDto;
import com.example.demo.models.DoacaoModelo;
import com.example.demo.models.UsuarioModelo;
import org.springframework.stereotype.Component;

@Component
public class DoacaoMapper {

    public DoacaoModelo toEntity(DoacaoRequisicaoDto dto, UsuarioModelo usuario) {
        DoacaoModelo doacao = new DoacaoModelo();
        doacao.setTitulo(dto.titulo());
        doacao.setDescricao(dto.descricao());
        doacao.setLocalizacao(dto.localizacao());
        doacao.setEmpresa(dto.empresa());
        doacao.setTempo(dto.tempo());
        doacao.setValor(dto.valor());
        doacao.setUsuarioCriador(usuario);
        return doacao;
    }

    public DoacaoRespostaDto toDto(DoacaoModelo doacao) {
        return new DoacaoRespostaDto(
                doacao.getId(),
                doacao.getTitulo(),
                doacao.getDescricao(),
                doacao.getLocalizacao(),
                doacao.getEmpresa(),
                doacao.getTempo(),
                doacao.getValor(),
                doacao.getUsuarioCriador()
        );
    }
}
