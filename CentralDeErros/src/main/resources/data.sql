/* DADOS INICIAIS PARA TESTE */
INSERT INTO USUARIO VALUES (1, 'Renata');
INSERT INTO USUARIO VALUES (2, 'Grace');
INSERT INTO USUARIO VALUES (3, 'Caue');
INSERT INTO USUARIO VALUES (4, 'Jaqueline');
INSERT INTO USUARIO VALUES (5, 'Luana');

INSERT INTO LOG VALUES (1, 0, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 0, 'Origem', 1, 1);
INSERT INTO LOG VALUES (2, 1, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 1, 'Origem', 1, 1);
INSERT INTO LOG VALUES (3, 2, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 2, 'Origem', 1, 1);

INSERT INTO LOG VALUES (4, 0, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 0, 'Origem', 1, 2);
INSERT INTO LOG VALUES (5, 1, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 1, 'Origem', 1, 2);
INSERT INTO LOG VALUES (6, 2, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 2, 'Origem', 1, 2);

INSERT INTO LOG VALUES (7, 0, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 0, 'Origem', 1, 3);
INSERT INTO LOG VALUES (8, 1, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 1, 'Origem', 1, 3);
INSERT INTO LOG VALUES (9, 2, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 2, 'Origem', 1, 3);

INSERT INTO LOG VALUES (10, 0, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 0, 'Origem', 1, 4);
INSERT INTO LOG VALUES (11, 1, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 1, 'Origem', 1, 4);
INSERT INTO LOG VALUES (12, 2, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 2, 'Origem', 1, 4);

INSERT INTO LOG VALUES (13, 0, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 0, 'Origem', 1, 5);
INSERT INTO LOG VALUES (14, 1, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 1, 'Origem', 1, 5);
INSERT INTO LOG VALUES (15, 2, CURRENT_TIMESTAMP(), 'Descricao', 'Log_Evento', 2, 'Origem', 1, 5);
