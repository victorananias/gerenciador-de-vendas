
DROP DATABASE IF EXISTS `gerenciamento_vendas`;

CREATE DATABASE `gerenciamento_vendas`;

USE `gerenciamento_vendas`;

CREATE TABLE IF NOT EXISTS `produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `tipo` char(1) DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL UNIQUE,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `tipo` char(1) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `vendas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade_total` int(11) NOT NULL,
  `valor_total` double NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`usuario_id`) REFERENCES usuarios(`id`)
);


CREATE TABLE IF NOT EXISTS `itens_venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `venda_id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `valor` double DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`produto_id`) REFERENCES produtos(`id`),
  FOREIGN KEY (`venda_id`) REFERENCES vendas(`id`) ON DELETE CASCADE
);

-- Senha: "123123123"
INSERT INTO `usuarios` VALUES(null, 'admin','admin','F5BB0C8DE146C67B44BABBF4E6584CC0','11111111111','A');
