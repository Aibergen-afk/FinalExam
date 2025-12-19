CREATE TABLE t_role (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(50) UNIQUE
);

CREATE TABLE t_library (
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255)
);

CREATE TABLE t_reader (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          age INT,
                          reader_bio VARCHAR(255),
                          email VARCHAR(255) UNIQUE,
                          password VARCHAR(255),
                          library_id BIGINT,
                          CONSTRAINT fk_library FOREIGN KEY (library_id) REFERENCES t_library(id)
);

CREATE TABLE reader_roles (
                              reader_id BIGINT REFERENCES t_reader(id),
                              role_id BIGINT REFERENCES t_role(id)
);
