package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.TransferenciaRequestDTO;
import com.example.demo.dtos.TransferenciaResponseDTO;
import com.example.demo.mappers.TransferenciaMapper;
import com.example.demo.models.Transferencia;
import com.example.demo.repositories.TransferenciaRepository;

@Service
public class TransferenciaService {
    private final TransferenciaRepository repository;

    public TransferenciaService(TransferenciaRepository repository) {
        this.repository = repository;
    }

    public List<TransferenciaResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(TransferenciaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public TransferenciaResponseDTO getById(Long id) {
        Transferencia transferencia = repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        return TransferenciaMapper.toResponseDTO(transferencia);
    }

    public TransferenciaResponseDTO create(TransferenciaRequestDTO dto) {
        Transferencia transferencia = TransferenciaMapper.toEntity(dto);
        repository.save(transferencia);
        return TransferenciaMapper.toResponseDTO(transferencia);
    }

    public TransferenciaResponseDTO update(Long id, TransferenciaRequestDTO dto) {
        Transferencia transferencia = repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        transferencia.setOrigem(dto.getOrigem());
        transferencia.setDestino(dto.getDestino());
        transferencia.setValor(dto.getValor());
        repository.save(transferencia);
        return TransferenciaMapper.toResponseDTO(transferencia);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
