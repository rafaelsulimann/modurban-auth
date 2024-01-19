package com.modurban.auth.usecases.obterusuariologado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.modurban.auth.models.Usuario;

import lombok.Getter;

@Getter
public class ObterUsuarioLogadoResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private List<String> roles = new ArrayList<>();

    public ObterUsuarioLogadoResponse(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        usuario.getRoles().forEach(role -> roles.add(role.getAuthority()));
    }

}
