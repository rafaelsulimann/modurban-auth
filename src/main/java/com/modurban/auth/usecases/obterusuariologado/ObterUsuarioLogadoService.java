package com.modurban.auth.usecases.obterusuariologado;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.modurban.auth.models.Usuario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObterUsuarioLogadoService implements UserDetailsService {

    private final ObterUsuarioLogadoRepository obterUsuarioLogadoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> userDetails = this.obterUsuarioLogadoRepository.findByEmail(username);
        if (!userDetails.isPresent()) {
            throw new UsernameNotFoundException("Email not found");
        }
        return userDetails.get();
    }

    protected Usuario authenticated(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Usuario> usuario = this.obterUsuarioLogadoRepository.findByEmail(username);
        if(!usuario.isPresent()){
            throw new UsernameNotFoundException("Invalid username");
        }
        return usuario.get();
    }

    public ObterUsuarioLogadoResponse getMe() {
        Usuario usuario = this.authenticated();
        return new ObterUsuarioLogadoResponse(usuario);
    }

}
