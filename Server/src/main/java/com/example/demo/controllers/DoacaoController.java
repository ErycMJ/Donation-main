package com.example.demo.controllers;

import com.example.demo.dtos.DoacaoRequisicaoDto;
import com.example.demo.dtos.DoacaoRespostaDto;
import com.example.demo.services.DoacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    private final DoacaoService doacaoService;

    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }

    @GetMapping
    public List<DoacaoRespostaDto> listarTodas() {
        return doacaoService.listarTodas();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<DoacaoRespostaDto> listarPorUsuario(@PathVariable UUID usuarioId) {
        return doacaoService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public ResponseEntity<DoacaoRespostaDto> criar(@RequestBody DoacaoRequisicaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doacaoService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoacaoRespostaDto> atualizar(
            @PathVariable UUID id,
            @RequestBody DoacaoRequisicaoDto dto
    ) {
        return ResponseEntity.ok(doacaoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        doacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}