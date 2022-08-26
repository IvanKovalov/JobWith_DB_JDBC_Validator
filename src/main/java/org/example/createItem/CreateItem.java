package org.example.createItem;

import org.example.DTO.StoreDTO;
import org.example.DTO.TypeDTO;
import org.example.DTO.ProductDTO;
import org.example.ProductDTORandomaizer;

public class CreateItem {
    public StoreDTO createStore(String name, String address){
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setAddress(address);
        storeDTO.setName(name);
        return storeDTO;
    }

    public TypeDTO createType(String typeName){
        TypeDTO typeDTO =new TypeDTO();
        typeDTO.setType(typeName);
        return  typeDTO;
    }

    public ProductDTO createProduct(){
        ProductDTORandomaizer productDTORandomaizer = new ProductDTORandomaizer();
        return  productDTORandomaizer.createDTO();
    }
}
