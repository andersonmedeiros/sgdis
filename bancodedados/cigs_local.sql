-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cigs_local
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cigs_local
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cigs_local` DEFAULT CHARACTER SET utf8 ;
USE `cigs_local` ;

-- -----------------------------------------------------
-- Table `cigs_local`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`Categoria` (
  `id` INT(11) NOT NULL,
  `nome` CHAR(1) NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cigs_local`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`Curso` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `sigla` VARCHAR(10) NOT NULL,
  `portaria` VARCHAR(80) NOT NULL,
  `descricao` VARCHAR(250) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Curso_Categoria1_idx` (`idCategoria` ASC),
  CONSTRAINT `fk_Curso_Categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `cigs_local`.`Categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cigs_local`.`Grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`Grade` (
  `codigo` VARCHAR(20) NOT NULL,
  `descricao` VARCHAR(70) NOT NULL,
  `ano` INT(11) NOT NULL,
  `variacao` INT(11) NOT NULL,
  `situacao` CHAR(1) NOT NULL DEFAULT 'I',
  `idCurso` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`, `idCurso`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC),
  INDEX `fk_Grade_Curso_idx` (`idCurso` ASC),
  CONSTRAINT `fk_Grade_Curso`
    FOREIGN KEY (`idCurso`)
    REFERENCES `cigs_local`.`Curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cigs_local`.`Modalidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`Modalidade` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cigs_local`.`Modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`Modulo` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cigs_local`.`Fase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`Fase` (
  `codigo` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `abreviatura` VARCHAR(15) NOT NULL,
  `descricao` VARCHAR(250) NOT NULL,
  `codigoGrade` VARCHAR(20) NOT NULL,
  `idCurso` INT(11) NOT NULL,
  `idModalidade` INT(11) NOT NULL,
  `idModulo` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Fase_Grade1_idx` (`codigoGrade` ASC, `idCurso` ASC),
  INDEX `fk_Fase_Modalidade1_idx` (`idModalidade` ASC),
  INDEX `fk_Fase_Modulo1_idx` (`idModulo` ASC),
  CONSTRAINT `fk_Fase_Grade1`
    FOREIGN KEY (`codigoGrade` , `idCurso`)
    REFERENCES `cigs_local`.`Grade` (`codigo` , `idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fase_Modalidade1`
    FOREIGN KEY (`idModalidade`)
    REFERENCES `cigs_local`.`Modalidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fase_Modulo1`
    FOREIGN KEY (`idModulo`)
    REFERENCES `cigs_local`.`Modulo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cigs_local`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`Disciplina` (
  `codigo` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `abreviatura` VARCHAR(15) NOT NULL,
  `codigoFase` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Disciplina_Fase1_idx` (`codigoFase` ASC),
  CONSTRAINT `fk_Disciplina_Fase1`
    FOREIGN KEY (`codigoFase`)
    REFERENCES `cigs_local`.`Fase` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cigs_local`.`Assunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`Assunto` (
  `codigo` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `chDiurna` INT(11) NOT NULL,
  `chNoturna` INT(11) NOT NULL,
  `codigoDisciplina` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Assunto_Disciplina1_idx` (`codigoDisciplina` ASC),
  CONSTRAINT `fk_Assunto_Disciplina1`
    FOREIGN KEY (`codigoDisciplina`)
    REFERENCES `cigs_local`.`Disciplina` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cigs_local`.`ForcaArmada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`ForcaArmada` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sigla` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cigs_local`.`PostoGraduacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`PostoGraduacao` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(40) NOT NULL,
  `abreviatura` VARCHAR(8) NOT NULL,
  `idForcaArmada` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `idForcaArmada`),
  INDEX `fk_PostoGraduacao_ForcaArmada1_idx` (`idForcaArmada` ASC),
  CONSTRAINT `fk_PostoGraduacao_ForcaArmada1`
    FOREIGN KEY (`idForcaArmada`)
    REFERENCES `cigs_local`.`ForcaArmada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cigs_local`.`QasQms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`QasQms` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `idForcaArmada` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `idForcaArmada`),
  INDEX `fk_QasQms_ForcaArmada1_idx` (`idForcaArmada` ASC),
  CONSTRAINT `fk_QasQms_ForcaArmada1`
    FOREIGN KEY (`idForcaArmada`)
    REFERENCES `cigs_local`.`ForcaArmada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cigs_local`.`RegiaoMilitar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`RegiaoMilitar` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sigla` VARCHAR(4) NOT NULL,
  `idForcaArmada` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `idForcaArmada`),
  INDEX `fk_RegiaoMilitar_ForcaArmada1_idx` (`idForcaArmada` ASC),
  CONSTRAINT `fk_RegiaoMilitar_ForcaArmada1`
    FOREIGN KEY (`idForcaArmada`)
    REFERENCES `cigs_local`.`ForcaArmada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cigs_local`.`EstadoCivil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cigs_local`.`EstadoCivil` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
