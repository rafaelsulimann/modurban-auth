package com.modurban.auth.usecases.obterusuariologado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modurban.auth.models.Usuario;

@Repository
public interface ObterUsuarioLogadoRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByEmail(String email);

}
