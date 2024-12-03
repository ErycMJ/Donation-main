package com.example.demo.mappers;

import com.example.demo.dtos.TransferenciaRequisicaoDto;
import com.example.demo.dtos.TransferenciaRespostaDto;
import com.example.demo.models.TransferenciaModelo;
import com.example.demo.models.UsuarioModelo;
import org.springframework.stereotype.Component;

@Component
public class TransferenciaMapper {

    public TransferenciaModelo toEntity(TransferenciaRequisicaoDto dto, UsuarioModelo remetente, UsuarioModelo destinatario) {
        TransferenciaModelo transferencia = new TransferenciaModelo();
        transferencia.setRemetente(remetente);
        transferencia.setDestinatario(destinatario);
        transferencia.setValor(dto.valor());
        transferencia.setDataTransferencia(java.time.LocalDateTime.now());
        return transferencia;
    }

    public TransferenciaRespostaDto toDto(TransferenciaModelo transferencia) {
        return new TransferenciaRespostaDto(
                transferencia.getId(),
                transferencia.getRemetente().getId(),
                transferencia.getDestinatario().getId(),
                transferencia.getValor(),
                transferencia.getDataTransferencia()
        );
    }
}
