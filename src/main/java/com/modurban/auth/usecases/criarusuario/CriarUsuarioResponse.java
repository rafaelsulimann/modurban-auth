package com.modurban.auth.usecases.criarusuario;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.modurban.auth.models.Usuario;

import lombok.Getter;

@Getter
public class CriarUsuarioResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private String senha;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataCriacao;

    public CriarUsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.dataCriacao = usuario.getDataCriacao();
    }

}
