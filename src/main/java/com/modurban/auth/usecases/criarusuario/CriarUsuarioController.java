package com.modurban.auth.usecases.criarusuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modurban.auth.models.Usuario;
import com.modurban.auth.utils.Path;

@RestController
@RequestMapping(value = Path.USUARIO)
public class CriarUsuarioController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CriarUsuarioResponse> criarUsuario(@RequestBody @Valid CriarUsuarioRequest request){
        Usuario usuario = request.toUsuario();
        this.manager.persist(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CriarUsuarioResponse(usuario));
    }
    
}
