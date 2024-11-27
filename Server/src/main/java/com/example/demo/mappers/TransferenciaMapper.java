package com.example.demo.mappers;

import java.time.LocalDateTime;

import com.example.demo.dtos.TransferenciaRequestDTO;
import com.example.demo.dtos.TransferenciaResponseDTO;
import com.example.demo.models.Transferencia;

public class TransferenciaMapper {
    public static Transferencia toEntity(TransferenciaRequestDTO dto) {
        Transferencia transferencia = new Transferencia();
        transferencia.setOrigem(dto.getOrigem());
        transferencia.setDestino(dto.getDestino());
        transferencia.setValor(dto.getValor());
        transferencia.setDataTransferencia(LocalDateTime.now());
        return transferencia;
    }

    public static TransferenciaResponseDTO toResponseDTO(Transferencia transferencia) {
        TransferenciaResponseDTO responseDTO = new TransferenciaResponseDTO();
        responseDTO.setId(transferencia.getId());
        responseDTO.setOrigem(transferencia.getOrigem());
        responseDTO.setDestino(transferencia.getDestino());
        responseDTO.setValor(transferencia.getValor());
        responseDTO.setDataTransferencia(transferencia.getDataTransferencia());
        return responseDTO;
    }
}
