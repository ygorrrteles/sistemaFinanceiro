create table CATEGORIA (
    CODIGO BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR (50) NOT NULL,
    ATIVO BOOLEAN NOT NULL,
    LOGRADOURO VARCHAR(100) NOT NULL,
    NUMERO VARCHAR(100) NOT NULL,
    COMPLEMENTO VARCHAR(100) NOT NULL,
    BAIRRO VARCHAR(100) NOT NULL,
    CEO VARCHAR(100) NOT NULL,
    CIDADE VARCHAR(100) NOT NULL,
    ESTADO VARCHAR(100) NOT NULL
)ENGINE=InnoDB default CHARSET = utf8;