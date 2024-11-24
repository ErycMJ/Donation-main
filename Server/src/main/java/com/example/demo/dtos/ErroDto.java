package com.example.demo.dtos;

import org.springframework.http.HttpStatus;

public record ErroDto(
        HttpStatus status,
        String razao
) {
}
