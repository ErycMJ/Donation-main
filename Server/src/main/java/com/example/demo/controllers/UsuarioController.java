package com.example.demo.controllers;

import com.example.demo.dtos.ErroDto;
import com.example.demo.dtos.UsuarioRequisicaoDto;
import com.example.demo.dtos.UsuarioRespostaDto;
import com.example.demo.services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    // SAVE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UsuarioRespostaDto insereUsuario(@RequestBody @Valid UsuarioRequisicaoDto usuario) {
        return usuarioService.insereUsuario(usuario);
    }

    // GET ALL
    @GetMapping
    public List<UsuarioRespostaDto> retornaUsuarios(
            @RequestParam(defaultValue = "0") Integer pagina,
            @RequestParam(defaultValue = "5") Integer tamanhoPagina
    ) {
        return usuarioService.retornaUsuarios(pagina, tamanhoPagina);
    }

    // GET ONE
    @GetMapping("/{id}")
    public UsuarioRespostaDto retornaUsuarioPorId(@PathVariable UUID id) {
        return usuarioService.retornaUsuarioPorId(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioRespostaDto deletarUsuarioPorId(@PathVariable UUID id) {
        return usuarioService.deletarUsuarioPorId(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroDto erroDeValidacao(HttpServletRequest req, MethodArgumentNotValidException exception) {
        return new ErroDto(
                HttpStatus.BAD_REQUEST,
                exception.getAllErrors().get(0).getDefaultMessage()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroDto erroDeValidacao(RuntimeException exception) {
        return new ErroDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage()
        );
    }
}
