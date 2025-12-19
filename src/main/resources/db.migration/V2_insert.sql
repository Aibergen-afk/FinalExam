INSERT INTO t_library (name) VALUES
                                 ('Central Library'),
                                 ('City Library'),
                                 ('University Library');

INSERT INTO t_role (name) VALUES
    ('ROLE_USER');

INSERT INTO t_reader (name, age, bio, email, password, library_id) VALUES
                                                                       ('Daiana', 19, 'd', 'daiana@mail.com', '$2a$10$abcdefghijklmnopqrstuv', 1),
                                                                       ('Nuridin', 20, 'n', 'nuridin@mail.com', '$2a$10$abcdefghijklmnopqrstuv', 2),
                                                                       ('Aibergen', 19, 'a', 'aibergen@mail.com', '$2a$10$abcdefghijklmnopqrstuv', 1);

INSERT INTO t_reader_roles (reader_id, role_id) VALUES
                                                    (1, 1),
                                                    (2, 1),
                                                    (3, 1);
