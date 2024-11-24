package com.example.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequisicaoDto(
        @NotNull String nome,
        @NotNull @Email String email,
        @NotBlank(message = "A senha não pode ser em branco") String senha

) {
}
