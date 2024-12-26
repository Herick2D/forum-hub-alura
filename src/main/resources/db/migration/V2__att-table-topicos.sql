CREATE TABLE IF NOT EXISTS topicos (
    id bigint not null auto_increment,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor BIGINT NOT NULL,
    curso BIGINT NOT NULL
    );
