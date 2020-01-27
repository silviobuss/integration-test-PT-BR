package com.jornada.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CONTATO")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTelefoneEnum tipo;
    @NotNull
    private String telefone;
    @JsonIgnore
    @ManyToOne
    private Usuario usuario;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoTelefoneEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefoneEnum tipo) {
        this.tipo = tipo;
    }
}
