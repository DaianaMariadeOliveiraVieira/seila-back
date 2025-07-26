-- Gêneros

INSERT INTO tb_genero (id, descricao) VALUES (1, 'Fantasia');
INSERT INTO tb_genero (id, descricao) VALUES (2, 'Terror');
INSERT INTO tb_genero (id, descricao) VALUES (3, 'Animação');

-- Plano

INSERT INTO tb_plano (id, descricao, valor) VALUES (1, 'Básico', 29.90);
INSERT INTO tb_plano (id, descricao, valor) VALUES (2, 'Premium', 3049.90);

-- Cliente

INSERT INTO tb_cliente(nome, cpf, email, login, senha, nivel_acesso) VALUES ('João Silva', '12345678901', 'joao.silva@email.com', 'joaodasilva', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'CLIENTE');
INSERT INTO tb_cliente(nome, cpf, email, login, senha, nivel_acesso) VALUES ('Gabriel Oliveira', '10771656686', 'gabriel410oliveira@gmail.com', 'gabrieloliveira', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'CLIENTE');
INSERT INTO tb_cliente(nome, cpf, email, login, senha, nivel_acesso) VALUES ('Daiana Maria', '14330293678', 'daiana_vieira99@hotmail.com', 'daianamaria', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'ADMIN');

-- Filmes (com IDs únicos)

INSERT INTO tb_filme(id, nome,sinopse, url_imagem, url_video) VALUES (1, 'O Senhor dos Anéis: A Sociedade do Anel', 'UM ANEL PARA TODOS GOVERNAR','https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/92/91/32/20224832.jpg', 'https://www.youtube.com/watch?v=oPwvcWPh3LM');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (2, 'O Senhor dos Anéis: As Duas Torres', 'UM ANEL PARA TODOS GOVERNAR','https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/92/34/89/20194741.jpg', 'https://www.youtube.com/watch?v=l7eDpuq_V7I');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (3, 'O Senhor dos Anéis: O Retorno do Rei', 'UM ANEL PARA TODOS GOVERNAR','https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/92/91/47/20224867.jpg', 'https://www.youtube.com/watch?v=LiKeQrChkTY');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (4, 'O Hobbit: Uma Jornada Inesperada', 'UM ANEL PARA TODOS GOVERNAR','https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/91/86/25/20180397.jpg', 'https://www.youtube.com/watch?v=4AKkpnCKa2I');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (5, 'Ringu', 'Sadako do poço','https://m.media-amazon.com/images/M/MV5BZTI3ZjZlN2MtYWI1Zi00YTc3LWI4ZDQtZTdkNTBiNzVhMjY4XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'https://www.youtube.com/watch?v=AJ2jLZq25J4');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (6, 'Ju on', 'Kayako da escada','https://www.papodecinema.com.br/wp-content/uploads/2020/01/20200130-o-grito-papo-de-cinema-cartaz.webp', 'https://www.youtube.com/watch?v=BxbBdEA7ZCQ');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (7, 'The Thing', 'Alien que transforma em gente pra matar gente','https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/96/76/33/20487876.jpg', 'https://www.youtube.com/watch?v=5ftmr17M-a4');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (8, 'Halloween - A Noite do Terror', 'Tananananan','https://br.web.img3.acsta.net/c_310_420/pictures/15/03/10/17/12/529336.jpg','https://www.youtube.com/watch?v=7cFHVoIh_KI');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (9,'Nausicaä', 'Meio ambiente','https://upload.wikimedia.org/wikipedia/pt/1/19/Kaze_no_Tani_no_Naushika_p%C3%B4ster.png', 'https://www.youtube.com/watch?v=6zhLBe319KE');
INSERT INTO tb_filme (id, nome,sinopse, url_imagem, url_video) VALUES (10, 'Princesa Mononoke', 'Meio ambiente AGAIN','https://m.media-amazon.com/images/I/81jSJRqb9IL._UF1000,1000_QL80_.jpg', 'https://www.youtube.com/watch?v=opCxPAwdB6U');
INSERT INTO tb_filme (id, nome,sinopse, url_imagem, url_video) VALUES (11, 'A Viagem de Chihiro', 'Meio ambiente so que com casas de banho','https://lojasebocultural.com.br/wp-content/uploads/2024/06/d0dbe14058effec9ae3b5f2c7ec0bdbb.jpg','https://www.youtube.com/watch?v=GAp2_0JJskk');
INSERT INTO tb_filme (id, nome,sinopse, url_imagem, url_video) VALUES (12, 'O Castelo Animado', 'Homem fazendo drama','https://br.web.img3.acsta.net/c_310_420/pictures/15/03/26/16/44/393405.jpg', 'https://www.youtube.com/watch?v=2x5SejvTMeA');
-- Associação filme-genero

INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (1, 1); -- Sociedade do Anel → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (2, 1); -- Duas Torres → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (3, 1); -- Retorno do Rei → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (4, 1); -- Uma Jornada Inesperada → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (5, 2); -- Ringu → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (6, 2); -- Ju on → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (7, 2); -- The Thing → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (8, 2); -- Halloween → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (9, 3); -- Nausicaä  → Animação
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (10, 3); -- Mononoke → Animação
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (11, 3); -- Chihiro → Animação
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (12, 3); -- Castelo Animado → Animação


-- Perfil do cliente

INSERT INTO tb_perfil (id_cliente, id_genero, gosta_do_genero) VALUES (1, 1, true);

-- Assinatura do cliente

INSERT INTO tb_assinatura (id_cliente, id_plano, data_inicio, data_fim, ativa) VALUES (1, 1, CURRENT_DATE, NULL, true);

-- Avaliação

INSERT INTO tb_avaliacao (id, comentario, nota, id_cliente, id_filme, data) VALUES (1, 'Excelente!', 5.0, 1, 1, CURRENT_DATE);

-- Histórico

INSERT INTO tb_historico (id, id_cliente, id_filme, data)VALUES (1, 1, 1, CURRENT_DATE);
