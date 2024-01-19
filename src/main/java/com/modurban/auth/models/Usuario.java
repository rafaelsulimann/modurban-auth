package com.modurban.auth.models;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.modurban.auth.utils.Regex;
import com.modurban.auth.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.USUARIO)
@Getter
@Validated
public class Usuario implements UserDetails{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataCriacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /**
     * @Deprecated
     * Não utilizar!
     * Criado apenas por obrigação do hibernate
     */
    @Deprecated
    public Usuario(){
    }

    public Usuario(String nome, String email, String senha) {
        Assert.hasText(nome, "Nome não pode ser nulo ou em branco");
        Assert.hasText(email, "Email não pode ser nulo ou em branco");
        Assert.isTrue(email.matches(Regex.EMAIL), "Email precisa ser válido");
        Assert.hasText(senha, "Senha não pode ser nulo ou em branco");
        Assert.isTrue(senha.length() >= 6, "Senha precisa ter no mínimo 6 caracteres");
        Assert.isTrue(!senha.matches(Regex.BCRYPT_PATTERN), "Senha não pode estar encriptada");
        
        this.nome = nome;
        this.email = email;
        this.senha = new BCryptPasswordEncoder().encode(senha);
        this.dataCriacao = LocalDateTime.now();
    }

    public boolean hasRole(String roleName){
        for(Role role : roles){
            if(role.getAuthority().equals(roleName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

}
