CREATE SCHEMA IF NOT EXISTS public;
CREATE SCHEMA IF NOT EXISTS teste;

CREATE TABLE IF NOT EXISTS public.users (
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS teste.users (
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(20)
);

INSERT INTO users (id, name) VALUES (1, 'PUBLICO');
INSERT INTO teste.users (id, name) VALUES (1, 'TESTE');