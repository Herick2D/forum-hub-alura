CREATE TABLE IF NOT EXISTS topicos (
    id CHAR(36) PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor CHAR(36),
    curso CHAR(36)
    );
