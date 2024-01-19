package com.modurban.auth.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.modurban.auth.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.ROLE)
@Getter
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    /**
     * @Deprecated
     * Não utilizar!
     * Criado apenas por obrigação do hibernate
     */
    @Deprecated
    public Role(){
    }

    public Role(String authority) {
        this.authority = authority;
    }
    
}
