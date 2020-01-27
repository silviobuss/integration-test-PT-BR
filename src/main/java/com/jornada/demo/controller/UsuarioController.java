package com.jornada.demo.controller;

import com.jornada.demo.domain.Usuario;
import com.jornada.demo.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioServico.buscarPeloId(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServico.criar(usuario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity remover(@PathVariable("id") Long id) {
        usuarioServico.remover(id);
        return ResponseEntity.noContent().build();
    }
}
