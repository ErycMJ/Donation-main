package com.example.demo.controllers;

import com.example.demo.dtos.TransferenciaRequisicaoDto;
import com.example.demo.dtos.TransferenciaRespostaDto;
import com.example.demo.services.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping
    public List<TransferenciaRespostaDto> listarTodas() {
        return transferenciaService.listarTodas();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<TransferenciaRespostaDto> listarPorUsuario(@PathVariable UUID usuarioId) {
        return transferenciaService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public ResponseEntity<TransferenciaRespostaDto> criar(@RequestBody TransferenciaRequisicaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransferenciaRespostaDto> atualizar(
            @PathVariable UUID id,
            @RequestBody TransferenciaRequisicaoDto dto
    ) {
        return ResponseEntity.ok(transferenciaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        transferenciaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
