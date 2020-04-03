/* DADOS INICIAIS PARA TESTE */

INSERT INTO ROLES (ROLE) VALUES ('ADMIN');
INSERT INTO ROLES (ROLE) VALUES ('USER');

INSERT INTO USERS (id, active, created, email, name, password) VALUES (1, true, now(), 'renata@abreu', 'Renata Abreu', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');
INSERT INTO USERS (id, active, created, email, name, password) VALUES (2, true, now(), 'grace@ferrari', 'Grace Ferrari', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');
INSERT INTO USERS (id, active, created, email, name, password) VALUES (3, true, now(), 'jaqueline@nascimento', 'Jaqueline Nascimento', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');
INSERT INTO USERS (id, active, created, email, name, password) VALUES (4, true, now(), 'caue@franca', 'Cauê França', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');
INSERT INTO USERS (id, active, created, email, name, password) VALUES (5, true, now(), 'luana@carolina', 'Luana Carolina', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (1, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 0, 1);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (2, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 0, 1);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (3, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 0, 1);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (4, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 0, 2);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (5, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 0, 2);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (6, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 0, 2);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (7, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 0, 3);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (8, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 0, 3);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (9, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 0, 3);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (10, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 0, 4);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (11, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 0, 4);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (12, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 0, 4);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (13, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 0, 5);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (14, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 0, 5);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (15, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 0, 5);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (16, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 1, 1);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (17, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 1, 1);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (18, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 1, 1);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (19, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 1, 2);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (20, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 1, 2);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (21, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 1, 2);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (22, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 1, 3);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (23, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 1, 3);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (24, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 1, 3);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (25, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 1, 4);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (26, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 1, 4);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (27, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 1, 4);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (28, NOW(), 0, 'Description', 'Event Long', 0, 'Source', 1, 5);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (29, NOW(), 1, 'Description', 'Event Long', 1, 'Source', 1, 5);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (30, NOW(), 2, 'Description', 'Event Long', 2, 'Source', 1, 5);