create table categoria (
    CODIGO BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR (50) NOT NULL
)ENGINE=InnoDB default CHARSET = utf8;

INSERT INTO categoria (nome) value ('Lazer');
INSERT INTO categoria (nome) value ('Alimentação');
INSERT INTO categoria (nome) value ('Supermercado');
INSERT INTO categoria (nome) value ('Combustivel');
INSERT INTO categoria (nome) value ('Tecnologia');
INSERT INTO categoria (nome) value ('Outros');