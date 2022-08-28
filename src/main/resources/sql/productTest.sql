CREATE TABLE IF NOT EXISTS productTest (
    `idProduct` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `typetest` INT NULL DEFAULT NULL,
     PRIMARY KEY (`idProduct`),
     UNIQUE INDEX `idProducttest_UNIQUE` (`idProduct` ASC) VISIBLE,
     INDEX `typetest_idx` (`typetest` ASC) VISIBLE,
     CONSTRAINT `typetest`
         FOREIGN KEY (`typetest`)
             REFERENCES typetest (`idType`));