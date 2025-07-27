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
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (5, 'O Labirinto do Fauno','Fantasia sombria','https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/87/14/49/19872468.jpg', 'https://www.youtube.com/watch?v=M09mCcVgrsA');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (6, 'Ringu', 'Sadako do poço','https://m.media-amazon.com/images/M/MV5BZTI3ZjZlN2MtYWI1Zi00YTc3LWI4ZDQtZTdkNTBiNzVhMjY4XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', 'https://www.youtube.com/watch?v=AJ2jLZq25J4');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (7, 'Ju on', 'Kayako da escada','https://www.papodecinema.com.br/wp-content/uploads/2020/01/20200130-o-grito-papo-de-cinema-cartaz.webp', 'https://www.youtube.com/watch?v=BxbBdEA7ZCQ');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (8, 'The Thing', 'Alien que transforma em gente pra matar gente','https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/96/76/33/20487876.jpg', 'https://www.youtube.com/watch?v=5ftmr17M-a4');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (9, 'Halloween - A Noite do Terror', 'Tananananan','https://br.web.img3.acsta.net/c_310_420/pictures/15/03/10/17/12/529336.jpg','https://www.youtube.com/watch?v=7cFHVoIh_KI');
INSERT INTO tb_filme (id,nome,sinopse, url_imagem, url_video) VALUES (10,'Nausicaä', 'Meio ambiente','https://upload.wikimedia.org/wikipedia/pt/1/19/Kaze_no_Tani_no_Naushika_p%C3%B4ster.png', 'https://www.youtube.com/watch?v=6zhLBe319KE');
INSERT INTO tb_filme (id, nome,sinopse, url_imagem, url_video) VALUES (11, 'Princesa Mononoke', 'Meio ambiente AGAIN','https://m.media-amazon.com/images/I/81jSJRqb9IL._UF1000,1000_QL80_.jpg', 'https://www.youtube.com/watch?v=opCxPAwdB6U');
INSERT INTO tb_filme (id, nome,sinopse, url_imagem, url_video) VALUES (12, 'A Viagem de Chihiro', 'Meio ambiente so que com casas de banho','https://lojasebocultural.com.br/wp-content/uploads/2024/06/d0dbe14058effec9ae3b5f2c7ec0bdbb.jpg','https://www.youtube.com/watch?v=GAp2_0JJskk');
INSERT INTO tb_filme (id, nome,sinopse, url_imagem, url_video) VALUES (13, 'O Castelo Animado', 'Homem fazendo drama','https://br.web.img3.acsta.net/c_310_420/pictures/15/03/26/16/44/393405.jpg', 'https://www.youtube.com/watch?v=2x5SejvTMeA');
INSERT INTO tb_filme (id, nome, sinopse, url_imagem, url_video) VALUES (14, 'A Bússola de Ouro', 'Garota enfrenta um mundo com criaturas mágicas e ursos falantes', 'https://br.web.img2.acsta.net/c_310_420/medias/nmedia/18/86/98/25/19870779.jpg', 'https://www.youtube.com/watch?v=7RHScwM1ims');
INSERT INTO tb_filme (id, nome, sinopse, url_imagem, url_video) VALUES (15, 'Hereditário', 'Família é atormentada por segredos macabros após a morte da avó', 'https://br.web.img2.acsta.net/c_310_420/pictures/18/06/14/13/11/1751062.jpg', 'https://www.youtube.com/watch?v=Ui13PlmyZhQ');

INSERT INTO tb_filme (id, nome, sinopse, url_imagem, url_video) VALUES (16, 'Ju On 2', 'É ESTUPIDAMENTE MELHOR QUE O 1', 'https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/87/07/47/19871755.jpg', 'https://www.youtube.com/watch?v=G-obcMiJ5ZI');
INSERT INTO tb_filme (id, nome, sinopse, url_imagem, url_video) VALUES (17, 'O Conto da Princesa Kaguya', 'Garota da lua vive na Terra entre humanos', 'https://br.web.img3.acsta.net/c_310_420/pictures/15/07/02/20/53/577027.jpg', 'https://www.youtube.com/watch?v=3u8bn1lUG_M');

INSERT INTO tb_filme (id, nome, sinopse, url_imagem, url_video) VALUES (18, 'Meu Amigo Totoro', 'Duas irmãs encontram criaturas mágicas na floresta', 'https://br.web.img3.acsta.net/c_310_420/pictures/15/03/25/19/44/392518.jpg', 'https://www.youtube.com/watch?v=92a7Hj0ijLs');

-- Associação filme-genero

INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (1, 1); -- Sociedade do Anel → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (2, 1); -- Duas Torres → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (3, 1); -- Retorno do Rei → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (4, 1); -- Uma Jornada Inesperada → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (5, 1); -- Labirinto do Fauno → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (6, 2); -- Ringu → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (7, 2); -- Ju on → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (8, 2); -- The Thing → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (9, 2); -- Halloween → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (10, 3); -- Nausicaä  → Animação
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (11, 3); -- Mononoke → Animação
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (12, 3); -- Chihiro → Animação
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (13, 3); -- Castelo Animado → Animação
-- Associação filme-genero (continuação)
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (14, 1); -- A Bússola de Ouro → Fantasia
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (15, 2); -- Hereditário → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (16, 2); -- Ju On 2 → Terror
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (17, 3); -- Princesa Kaguya → Animação
INSERT INTO tb_filme_genero (id_filme, id_genero) VALUES (18, 3); -- Totoro → Animação



-- Perfil do cliente

INSERT INTO tb_perfil (id_cliente, id_genero, gosta_do_genero) VALUES (1, 1, true);

-- Assinatura do cliente

INSERT INTO tb_assinatura (id_cliente, id_plano, data_inicio, data_fim, ativa) VALUES (1, 1, CURRENT_DATE, NULL, true);

-- Avaliação

INSERT INTO tb_avaliacao (id, comentario, nota, id_cliente, id_filme, data) VALUES (1, 'Excelente!', 5.0, 1, 1, CURRENT_DATE);
INSERT INTO tb_avaliacao (id, comentario, nota, id_cliente, id_filme, data) VALUES (2, 'Poderia ser melhor', 3.5, 2, 7, CURRENT_DATE);

-- Histórico

INSERT INTO tb_historico (id, id_cliente, id_filme, data)VALUES (1, 1, 1, CURRENT_DATE);
INSERT INTO tb_historico (id, id_cliente, id_filme, data) VALUES (2, 1, 2, CURRENT_DATE);
INSERT INTO tb_historico (id, id_cliente, id_filme, data) VALUES (3, 1, 3, CURRENT_DATE);
