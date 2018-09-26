-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cupcakeRecipes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cupcakeRecipes
-- -----------------------------------------------------
Drop schema if exists `cupcakeRecipes`;
CREATE SCHEMA IF NOT EXISTS `cupcakeRecipes` DEFAULT CHARACTER SET utf8 ;
USE `cupcakeRecipes` ;

-- -----------------------------------------------------
-- Table `cupcakeRecipes`.`Ingredient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakeRecipes`.`Ingredient` (
  `ingredientName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ingredientName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cupcakeRecipes`.`Recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakeRecipes`.`Recipe` (
  `recipeName` VARCHAR(45) NOT NULL,
  `created` INT NOT NULL,
  `instructions` VARCHAR(225) NULL DEFAULT NULL,
  `rating` INT(1) NOT NULL,
  `image` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`recipeName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cupcakeRecipes`.`IngredientDetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakeRecipes`.`IngredientDetails` (
  `qty` INT(11) NOT NULL,
  `recipeName` VARCHAR(45) NOT NULL,
  `ingredientName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`recipeName`, `ingredientName`),
  INDEX `fk_IngredientDetails_Recipe1_idx` (`recipeName` ASC),
  INDEX `fk_IngredientDetails_Ingredient1_idx` (`ingredientName` ASC),
  CONSTRAINT `fk_IngredientDetails_Recipe1`
    FOREIGN KEY (`recipeName`)
    REFERENCES `cupcakeRecipes`.`Recipe` (`recipeName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IngredientDetails_Ingredient1`
    FOREIGN KEY (`ingredientName`)
    REFERENCES `cupcakeRecipes`.`Ingredient` (`ingredientName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
