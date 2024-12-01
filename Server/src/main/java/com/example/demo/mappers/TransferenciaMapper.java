package com.example.demo.mappers;

import java.time.LocalDateTime;

import com.example.demo.dtos.TransferenciaRequestDTO;
import com.example.demo.dtos.TransferenciaResponseDTO;
import com.example.demo.models.DoacaoModelo;
import com.example.demo.models.Transferencia;
import com.example.demo.models.UsuarioModelo;

public class TransferenciaMapper {
    public static TransferenciaResponseDTO toResponseDTO(Transferencia transferencia) {
        return new TransferenciaResponseDTO(
                transferencia.getId(),
                transferencia.getOrigem().getNome(),
                transferencia.getDestino().getNome(),
                transferencia.getDoacao().getTitulo(),
                transferencia.getValor(),
                transferencia.getDataTransferencia()
        );
    }

    public static Transferencia toEntity(TransferenciaRequestDTO dto, UsuarioModelo origem, UsuarioModelo destino, DoacaoModelo doacao) {
        Transferencia transferencia = new Transferencia();
        transferencia.setOrigem(origem);
        transferencia.setDestino(destino);
        transferencia.setDoacao(doacao);
        transferencia.setValor(dto.getValor());
        transferencia.setDataTransferencia(LocalDateTime.now());
        return transferencia;
    }
}
