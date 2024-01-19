package com.modurban.auth.utils;

public final class TableName {

    public static final String USUARIO = "tb_usuarios";
    public static final String ROLE = "tb_roles";

    private TableName() {
        throw new AssertionError("Não é permitido instanciar esta classe.");
    }
    
}
