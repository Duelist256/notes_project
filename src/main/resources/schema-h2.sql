DROP SCHEMA IF EXISTS enote;

CREATE SCHEMA enote;

SET SCHEMA enote;

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`login`));

CREATE TABLE notes (
  id INT NOT NULL AUTO_INCREMENT,
  text TEXT NOT NULL,
  notebook_id INT NOT NULL,
  PRIMARY KEY (`id`));

 CREATE TABLE notebooks (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  PRIMARY KEY (`id`));