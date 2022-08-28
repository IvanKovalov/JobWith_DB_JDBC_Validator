

CREATE TABLE IF NOT EXISTS typetest (
                                                `idType` INT NOT NULL AUTO_INCREMENT,
                                                `type` VARCHAR(45) NOT NULL,
                                                PRIMARY KEY (`idType`),
                                                UNIQUE INDEX `idType_UNIQUE` (`idType` ASC) VISIBLE)






/*CREATE TABLE IF NOT EXISTS store_has_productsTest (
                                                              `idStore` INT NULL DEFAULT NULL,
                                                              `idProducts` INT NULL DEFAULT NULL,
                                                              INDEX `idProduct_idx` (`idProducts` ASC) VISIBLE,
                                                              INDEX `idStore_idx` (`idStore` ASC) VISIBLE,
                                                              CONSTRAINT `idProduct`
                                                                  FOREIGN KEY (`idProducts`)
                                                                      REFERENCES producttest (`idProduct`),
                                                              CONSTRAINT `idStore`
                                                                  FOREIGN KEY (`idStore`)
                                                                      REFERENCES storetest (`idStore`))
    ;*/

