CREATE TABLE IF NOT EXISTS store_has_productsTest (
    `idStoretest` INT NULL DEFAULT NULL,
    `idProductstest` INT NULL DEFAULT NULL,
     INDEX `idProducttest_idx` (`idProductstest` ASC) VISIBLE,
     INDEX `idStoretest_idx` (`idStoretest` ASC) VISIBLE,
     CONSTRAINT `idProducttest`
         FOREIGN KEY (`idProductstest`)
             REFERENCES producttest (`idProduct`),
     CONSTRAINT `idStoretest`
         FOREIGN KEY (`idStoretest`)
             REFERENCES storetest (`idStore`))