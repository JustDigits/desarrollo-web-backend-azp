INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('justdigits', '$2a$10$6S03ZywS/XQYg/BeTvbTE.CYKjKXKQOeaKNkJ.3nLuv0R6M.uykdW', 1, 'Axell', 'Zuniga', 'test@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('nissan', '$2a$10$1H5HVEW9scanfHuBh16tUum3X5/z9qplSYzVM4SWoqUXjg1Jl2pcC', 1, 'Nissan', 'Gtr', 'nissan@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER')
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN')

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (1, 1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 1);