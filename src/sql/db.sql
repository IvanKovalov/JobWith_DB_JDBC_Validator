-- MySQL Workbench Forward Engineering


-- -----------------------------------------------------
-- Schema storedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema storedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `storedb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `storedb` ;

-- -----------------------------------------------------
-- Table `storedb`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `storedb`.`type` (
    `idType` INT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(45) NOT NULL,
     PRIMARY KEY (`idType`),
     UNIQUE INDEX `idType_UNIQUE` (`idType` ASC) VISIBLE)
    ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `storedb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `storedb`.`product` (
    `idProduct` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `type` INT NULL DEFAULT NULL,
     PRIMARY KEY (`idProduct`),
     UNIQUE INDEX `idProduct_UNIQUE` (`idProduct` ASC) VISIBLE,
     INDEX `type_idx` (`type` ASC) VISIBLE,
     CONSTRAINT `type`
         FOREIGN KEY (`type`)
             REFERENCES `storedb`.`type` (`idType`))
    ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `storedb`.`store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `storedb`.`store` (
    `idStore` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL DEFAULT NULL,
    `adress` VARCHAR(45) NULL DEFAULT NULL,
     PRIMARY KEY (`idStore`),
     UNIQUE INDEX `idStore_UNIQUE` (`idStore` ASC) VISIBLE)
    ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `storedb`.`store_has_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `storedb`.`store_has_products` (
    `idStore` INT NULL DEFAULT NULL,
    `idProducts` INT NULL DEFAULT NULL,
     INDEX `idProduct_idx` (`idProducts` ASC) VISIBLE,
     INDEX `idStore_idx` (`idStore` ASC) VISIBLE,
     CONSTRAINT `idProduct`
         FOREIGN KEY (`idProducts`)
             REFERENCES `storedb`.`product` (`idProduct`),
     CONSTRAINT `idStore`
         FOREIGN KEY (`idStore`)
             REFERENCES `storedb`.`store` (`idStore`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
