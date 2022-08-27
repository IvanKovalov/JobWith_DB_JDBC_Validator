CREATE TABLE IF NOT EXISTS storeTest (
                                         `idStore` INT NOT NULL AUTO_INCREMENT,
                                         `name` VARCHAR(45) NULL DEFAULT NULL,
                                         `adress` VARCHAR(45) NULL DEFAULT NULL,
                                         PRIMARY KEY (`idStore`),
                                         UNIQUE INDEX `idStore_UNIQUE` (`idStore` ASC) VISIBLE)

