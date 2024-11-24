package com.example.demo.services;

import com.example.demo.dtos.UsuarioRequisicaoDto;
import com.example.demo.dtos.UsuarioRespostaDto;
import com.example.demo.mappers.UsuarioMapper;
import com.example.demo.models.GrupoModelo;
import com.example.demo.models.UsuarioModelo;
import com.example.demo.repositories.GrupoRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    UsuarioMapper usuarioMapper;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    GrupoRepository grupoRepository;

    public UsuarioRespostaDto insereUsuario(UsuarioRequisicaoDto usuarioRequisicaoDto) {

        // UsuarioModelo
        UsuarioModelo usuario = new UsuarioModelo();
        usuario.setNome(usuarioRequisicaoDto.nome());
        usuario.setEmail(usuarioRequisicaoDto.email());
        usuario.setPassword(usuarioRequisicaoDto.senha());
        usuario.setEndereco("Rua do limoeiro");

        // Salva o usuario no banco de dados
        // salvar
        usuarioRepository.save(usuario);
        // Mapear o usuario model para usuario resposta dto
        return usuarioMapper.toDto(usuario);
    }

    public List<UsuarioRespostaDto> retornaUsuarios(Integer pagina, Integer tamanhoPagina) {
        Pageable paginaConfig = PageRequest.of(pagina, tamanhoPagina);
        return usuarioRepository.findAll(paginaConfig).stream().map(usuarioMapper::toDto).toList();
    }

    public UsuarioRespostaDto retornaUsuarioPorId(UUID id) {
        UsuarioModelo usuario =  usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
        return usuarioMapper.toDto(usuario);
    }

    public UsuarioRespostaDto deletarUsuarioPorId(UUID id) {
        UsuarioModelo usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
        usuarioRepository.delete(usuario);
        return usuarioMapper.toDto(usuario);
    }
}
