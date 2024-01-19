INSERT INTO tb_usuarios (nome, email, senha, data_criacao) VALUES ('Rafael','sulimannrafael@gmail.com', '$2a$10$VRQPZhFz1UbKo3THC0le1.tI3vsLdfdSFjjmMMOLstP8uqrrtDtlm', TIMESTAMP WITH TIME ZONE '2023-11-23T13:00:00Z')
INSERT INTO tb_usuarios (nome, email, senha, data_criacao) VALUES ('Luana','luana@gmail.com', '$2a$10$VRQPZhFz1UbKo3THC0le1.tI3vsLdfdSFjjmMMOLstP8uqrrtDtlm', TIMESTAMP WITH TIME ZONE '2023-11-23T13:00:00Z')

INSERT INTO tb_roles (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_roles (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuarios_roles (usuario_id, role_id) VALUES (2, 1);
INSERT INTO tb_usuarios_roles (usuario_id, role_id) VALUES (2, 2);