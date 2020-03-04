create table CATEGORIA (
    CODIGO BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR (50) NOT NULL
)ENGINE=InnoDB default CHARSET = utf8;

INSERT INTO CATEGORIA (nome) value ('Lazer');
INSERT INTO CATEGORIA (nome) value ('Alimentação');
INSERT INTO CATEGORIA (nome) value ('Supermercado');
INSERT INTO CATEGORIA (nome) value ('Combustivel');
INSERT INTO CATEGORIA (nome) value ('Tecnologia');
INSERT INTO CATEGORIA (nome) value ('Outros');