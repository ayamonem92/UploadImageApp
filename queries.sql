CREATE SCHEMA `db_example` ;

USE `db_example`;
-- Dumping structure for table concretepage.articles

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(60) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `enabled` tinyint  NULL default 1,
 
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(100) NOT NULL,
  `authority` varchar(45) NOT NULL,
 
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `db_example`.`image` (
  `name` varchar(500) NOT NULL,
  PRIMARY KEY (`name`));
