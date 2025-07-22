INSERT INTO tb_genero (id, descricao) VALUES (1, 'Ação');
INSERT INTO tb_plano (id, descricao, valor) VALUES (1, 'Básico', 29.90);
INSERT INTO tb_cliente(nome, cpf, email, login, senha, nivel_acesso) VALUES ('João da Silva', '12345678901', 'joao.silva@email.com', 'joaodasilva', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'CLIENTE');
INSERT INTO tb_filme (id, nome, sinopse) VALUES (1, 'Filme A', 'Sinopse...');
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (1, 1);
INSERT INTO tb_perfil (id_cliente, id_genero, gosta_do_genero) VALUES (1, 1, true);
INSERT INTO tb_assinatura (id_cliente, id_plano, data_inicio, data_fim, ativa) VALUES (1, 1, CURRENT_DATE, NULL, true);
INSERT INTO tb_avaliacao (id, comentario, nota, id_cliente, id_filme) VALUES (1, 'Excelente!', 5.0, 1, 1);
INSERT INTO tb_historico (id, id_cliente, id_filme, data) VALUES (1, 1, 1, CURRENT_DATE)
