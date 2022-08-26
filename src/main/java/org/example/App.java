package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DbHandler dbHandler = new DbHandler();
        dbHandler.Connect();
        dbHandler.addTypes();
        dbHandler.addProducts(10);
        dbHandler.addStore("Epicent","Popova 21");
        dbHandler.addStore("Epicent","Popova 16");
        dbHandler.addStore("Epicent","Popova 18");
        dbHandler.searchStoreWithTheMostTypes("private");
        System.out.println( "Hello World!");
    }
}


   /* SET FOREIGN_KEY_CHECKS = 0;
    TRUNCATE table store_has_products;
        TRUNCATE table store;
        TRUNCATE table type;
        TRUNCATE table product;

        SET FOREIGN_KEY_CHECKS = 1;
        select * from type;
        select * from store;

        SELECT adress  from (select  adress, count(t.type) as c from store left join store_has_products shp on store.idStore = shp.idStore left join product p on p.idProduct = shp.idProducts left join type t on t.idType = p.type where t.type = 'private' group by adress)s  order by c desc limit 1;
        select * from store left join store_has_products shp on store.idStore = shp.idStore left join product p on p.idProduct = shp.idProducts left join type t on t.idType = p.type*/