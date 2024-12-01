package com.example.demo.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.TransferenciaRequestDTO;
import com.example.demo.dtos.TransferenciaResponseDTO;
import com.example.demo.services.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public TransferenciaResponseDTO realizarTransferencia(
            @RequestParam UUID usuarioOrigemId,
            @RequestBody TransferenciaRequestDTO transferenciaRequestDTO) {
        return transferenciaService.realizarTransferencia(
                transferenciaRequestDTO.getDoacaoId(),
                usuarioOrigemId,
                transferenciaRequestDTO.getValor());
    }
}
