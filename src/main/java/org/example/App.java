package org.example;

import org.example.DTO.ProductDTO;
import org.example.DTO.StoreDTO;
import org.example.DTO.TypeDTO;
import org.example.createItem.CreateItem;
import org.example.ownValidator.CheckItem;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        ReadProperty readProperty = new ReadProperty();
        readProperty.getInfo();
        CreateItem createItem = new CreateItem();
        CheckItem checkItem = new CheckItem();

        DbHandler dbHandler = new DbHandler();

        dbHandler.connect(readProperty.getUrl(), readProperty.getUser(), readProperty.getPassword());
        dbHandler.dropTables();
        dbHandler.createTables();
        TypeDTO typeDTO = createItem.createType("private");
        TypeDTO typeDTO1 = createItem.createType("suspension");
        TypeDTO typeDTO2 = createItem.createType("congestive");
        TypeDTO typeDTO3 = createItem.createType("tubers");
        dbHandler.addTypes(typeDTO, checkItem.check(typeDTO));
        dbHandler.addTypes(typeDTO1, checkItem.check(typeDTO1));
        dbHandler.addTypes(typeDTO2, checkItem.check(typeDTO2));
        dbHandler.addTypes(typeDTO3, checkItem.check(typeDTO3));


        int productCount = 100;
        for(int i = 0; i < productCount; i++) {
            ProductDTO productDTO = createItem.createProduct();
            checkItem.check(productDTO);
            dbHandler.addProduct(productDTO, checkItem.check(productDTO));
        }


        StoreDTO storeDTO = createItem.createStore("Epicentr", "Popova 16");
        StoreDTO storeDTO1 = createItem.createStore("Epicentr", "Popova 18");
        StoreDTO storeDTO2 = createItem.createStore("Epicentr", "Popova 21");

        dbHandler.addStore(storeDTO, checkItem.check(storeDTO));
        dbHandler.addStore(storeDTO1, checkItem.check(storeDTO1));
        dbHandler.addStore(storeDTO2, checkItem.check(storeDTO2));

        dbHandler.searchStoreWithTheMostTypes(args[0]);

    }
}

