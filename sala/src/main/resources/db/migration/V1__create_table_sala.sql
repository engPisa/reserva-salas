CREATE TABLE Sala(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    localizacao VARCHAR(255) NOT NULL,
    capacidade INTEGER NOT NULL,
    -- Impede criação de salas duplicadas com nome e localizacao
    CONSTRAINT uq_sala_nome_localizacao UNIQUE (nome, localizacao)
);