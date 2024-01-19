package com.modurban.auth.usecases.obterusuariologado;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modurban.auth.utils.Path;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = Path.USUARIO)
@RequiredArgsConstructor
public class ObterUsuarioLogadoController {

    private final ObterUsuarioLogadoService obterUsuarioLogadoService;

    @GetMapping(value = "/me")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<ObterUsuarioLogadoResponse> getMe(){
        return ResponseEntity.status(HttpStatus.OK).body(this.obterUsuarioLogadoService.getMe());
    }
    
}
