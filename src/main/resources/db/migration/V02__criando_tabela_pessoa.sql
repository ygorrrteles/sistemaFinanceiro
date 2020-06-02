create table pessoa (
    CODIGO BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR (50) NOT NULL,
    ATIVO BOOLEAN NOT NULL,
    LOGRADOURO VARCHAR(100),
    NUMERO VARCHAR(100),
    COMPLEMENTO VARCHAR(100),
    BAIRRO VARCHAR(100),
    CEP VARCHAR(100),
    CIDADE VARCHAR(100),
    ESTADO VARCHAR(100)
)ENGINE=InnoDB default CHARSET = utf8;