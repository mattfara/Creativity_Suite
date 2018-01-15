-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Creativity_Suite-test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Creativity_Suite-test` ;

-- -----------------------------------------------------
-- Schema Creativity_Suite-test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Creativity_Suite-test` DEFAULT CHARACTER SET utf8 ;
USE `Creativity_Suite-test` ;

-- -----------------------------------------------------
-- Table `Creativity_Suite-test`.`Ideas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Creativity_Suite-test`.`Ideas` ;

CREATE TABLE IF NOT EXISTS `Creativity_Suite-test`.`Ideas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` MEDIUMTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Creativity_Suite-test`.`Concepts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Creativity_Suite-test`.`Concepts` ;

CREATE TABLE IF NOT EXISTS `Creativity_Suite-test`.`Concepts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` MEDIUMTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Creativity_Suite-test`.`Values`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Creativity_Suite-test`.`Values` ;

CREATE TABLE IF NOT EXISTS `Creativity_Suite-test`.`Values` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` MEDIUMTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Creativity_Suite-test`.`Sessions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Creativity_Suite-test`.`Sessions` ;

CREATE TABLE IF NOT EXISTS `Creativity_Suite-test`.`Sessions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `start_time` TIME NOT NULL,
  `end_time` TIME NOT NULL,
  `hat_sequence` SET('red', 'white', 'blue', 'green', 'black', 'yellow') NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Creativity_Suite-test`.`Problems`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Creativity_Suite-test`.`Problems` ;

CREATE TABLE IF NOT EXISTS `Creativity_Suite-test`.`Problems` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` MEDIUMTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Creativity_Suite-test`.`Idea_Concepts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Creativity_Suite-test`.`Idea_Concepts` ;

CREATE TABLE IF NOT EXISTS `Creativity_Suite-test`.`Idea_Concepts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idea_id` INT NOT NULL,
  `concept_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Idea_Concepts_Ideas_idx` (`idea_id` ASC),
  INDEX `fk_Idea_Concepts_Concepts1_idx` (`concept_id` ASC),
  CONSTRAINT `fk_Idea_Concepts_Ideas`
    FOREIGN KEY (`idea_id`)
    REFERENCES `Creativity_Suite-test`.`Ideas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Idea_Concepts_Concepts1`
    FOREIGN KEY (`concept_id`)
    REFERENCES `Creativity_Suite-test`.`Concepts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Creativity_Suite-test`.`Idea_Values`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Creativity_Suite-test`.`Idea_Values` ;

CREATE TABLE IF NOT EXISTS `Creativity_Suite-test`.`Idea_Values` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idea_id` INT NOT NULL,
  `value_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Idea_Values_Ideas1_idx` (`idea_id` ASC),
  INDEX `fk_Idea_Values_Values1_idx` (`value_id` ASC),
  CONSTRAINT `fk_Idea_Values_Ideas1`
    FOREIGN KEY (`idea_id`)
    REFERENCES `Creativity_Suite-test`.`Ideas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Idea_Values_Values1`
    FOREIGN KEY (`value_id`)
    REFERENCES `Creativity_Suite-test`.`Values` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Creativity_Suite-test`.`Idea_Problems`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Creativity_Suite-test`.`Idea_Problems` ;

CREATE TABLE IF NOT EXISTS `Creativity_Suite-test`.`Idea_Problems` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idea_id` INT NOT NULL,
  `problem_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Idea_Problems_Ideas1_idx` (`idea_id` ASC),
  INDEX `fk_Idea_Problems_Problems1_idx` (`problem_id` ASC),
  CONSTRAINT `fk_Idea_Problems_Ideas1`
    FOREIGN KEY (`idea_id`)
    REFERENCES `Creativity_Suite-test`.`Ideas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Idea_Problems_Problems1`
    FOREIGN KEY (`problem_id`)
    REFERENCES `Creativity_Suite-test`.`Problems` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Creativity_Suite-test`.`Session_Problems`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Creativity_Suite-test`.`Session_Problems` ;

CREATE TABLE IF NOT EXISTS `Creativity_Suite-test`.`Session_Problems` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `session_id` INT NOT NULL,
  `problem_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Session_Problems_Sessions1_idx` (`session_id` ASC),
  INDEX `fk_Session_Problems_Problems1_idx` (`problem_id` ASC),
  CONSTRAINT `fk_Session_Problems_Sessions1`
    FOREIGN KEY (`session_id`)
    REFERENCES `Creativity_Suite-test`.`Sessions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Session_Problems_Problems1`
    FOREIGN KEY (`problem_id`)
    REFERENCES `Creativity_Suite-test`.`Problems` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

