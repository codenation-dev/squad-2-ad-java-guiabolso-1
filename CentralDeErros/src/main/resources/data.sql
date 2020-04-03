/* DADOS INICIAIS PARA TESTE */

INSERT INTO ROLES (ROLE) VALUES ('ADMIN');
INSERT INTO ROLES (ROLE) VALUES ('USER');

INSERT INTO USERS (id, active, created, email, name, password) VALUES (1, true, now(), 'renata@abreu', 'Renata Abreu', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');
INSERT INTO USERS (id, active, created, email, name, password) VALUES (2, true, now(), 'grace@ferrari', 'Grace Ferrari', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');
INSERT INTO USERS (id, active, created, email, name, password) VALUES (3, true, now(), 'jaqueline@nascimento', 'Jaqueline Nascimento', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');
INSERT INTO USERS (id, active, created, email, name, password) VALUES (4, true, now(), 'caue@franca', 'Cauê França', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');
INSERT INTO USERS (id, active, created, email, name, password) VALUES (5, true, now(), 'luana@carolina', 'Luana Carolina', '$2a$10$BXrgTIQ.BY9DinOCYQLt9uT4kuNlAu2HXs0G2.Qnf5IeqjzgV0ECG');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 2);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 2);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (4, 2);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (5, 2);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (1, now(), 0, 'Description', 'Event Long', 0, 'Source', 0, 1);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (2, now(), 1, 'Description', 'Event Long', 1, 'Source', 0, 1);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (3, now(), 2, 'Description', 'Event Long', 2, 'Source', 0, 1);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (4, now(), 0, 'Description', 'Event Long', 0, 'Source', 0, 2);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (5, now(), 1, 'Description', 'Event Long', 1, 'Source', 0, 2);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (6, now(), 2, 'Description', 'Event Long', 2, 'Source', 0, 2);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (7, now(), 0, 'Description', 'Event Long', 0, 'Source', 0, 3);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (8, now(), 1, 'Description', 'Event Long', 1, 'Source', 0, 3);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (9, now(), 2, 'Description', 'Event Long', 2, 'Source', 0, 3);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (10, now(), 0, 'Description', 'Event Long', 0, 'Source', 0, 4);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (11, now(), 1, 'Description', 'Event Long', 1, 'Source', 0, 4);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (12, now(), 2, 'Description', 'Event Long', 2, 'Source', 0, 4);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (13, now(), 0, 'Description', 'Event Long', 0, 'Source', 0, 5);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (14, now(), 1, 'Description', 'Event Long', 1, 'Source', 0, 5);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (15, now(), 2, 'Description', 'Event Long', 2, 'Source', 0, 5);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (16, now(), 0, 'Description', 'Event Long', 0, 'Source', 1, 1);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (17, now(), 1, 'Description', 'Event Long', 1, 'Source', 1, 1);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (18, now(), 2, 'Description', 'Event Long', 2, 'Source', 1, 1);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (19, now(), 0, 'Description', 'Event Long', 0, 'Source', 1, 2);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (20, now(), 1, 'Description', 'Event Long', 1, 'Source', 1, 2);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (21, now(), 2, 'Description', 'Event Long', 2, 'Source', 1, 2);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (22, now(), 0, 'Description', 'Event Long', 0, 'Source', 1, 3);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (23, now(), 1, 'Description', 'Event Long', 1, 'Source', 1, 3);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (24, now(), 2, 'Description', 'Event Long', 2, 'Source', 1, 3);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (25, now(), 0, 'Description', 'Event Long', 0, 'Source', 1, 4);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (26, now(), 1, 'Description', 'Event Long', 1, 'Source', 1, 4);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (27, now(), 2, 'Description', 'Event Long', 2, 'Source', 1, 4);

INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (28, now(), 0, 'Description', 'Event Long', 0, 'Source', 1, 5);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (29, now(), 1, 'Description', 'Event Long', 1, 'Source', 1, 5);
INSERT INTO LOG (id, date, environment, event_description, event_log, level, source, status, user_id) VALUES (30, now(), 2, 'Description', 'Event Long', 2, 'Source', 1, 5);