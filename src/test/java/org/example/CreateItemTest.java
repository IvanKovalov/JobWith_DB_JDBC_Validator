package org.example;


import org.example.DTO.ProductDTO;
import org.example.DTO.StoreDTO;
import org.example.DTO.TypeDTO;
import org.example.createItem.CreateItem;
import org.junit.Test;

import static org.junit.Assert.*;


public class CreateItemTest  {
    CreateItem createItem = new CreateItem();


    @Test
    public void TestCreateStoreDTO (){
        StoreDTO storeDTO = createItem.createStore("Epicentr", "Popova 16");
        assertEquals("Failed TestCreateStoreDTO","Epicentr", storeDTO.getName());
        assertEquals("Failed TestCreateStoreDTO","Popova 16", storeDTO.getAddress());
    }

    @Test
    public void TestCreateTypeDTO (){
        TypeDTO typeDTO = createItem.createType("private");
        assertEquals("Failed TestCreateTypeDTO", "private", typeDTO.getType() );
    }

    @Test
    public void TestCreateProductDTO (){
        ProductDTO productDTO = createItem.createProduct();
        assertNotNull("Failed TestCreateProductDTO",productDTO.getName());
        assertNotNull("Failed TestCreateProductDTO",productDTO.getType());
       // assertEquals("Failed TestCreateProductDTO", 1-4, productDTO.getType());
    }

}
