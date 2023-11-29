INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('justdigits', '12345', 1, 'Axell', 'Zuniga', 'test@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('nissan', '12345', 1, 'Nissan', 'Gtr', 'nissan@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER')
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN')

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (1, 1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 1);