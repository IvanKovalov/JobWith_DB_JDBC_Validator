package org.example.createItem;

import org.example.DTO.StoreDTO;
import org.example.DTO.TypeDTO;
import org.example.DTO.ProductDTO;
import org.example.ProductDTORandomaizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateItem {

    final static Logger logger = LoggerFactory.getLogger(CreateItem.class);
    public StoreDTO createStore(String name, String address){
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setAddress(address);
        storeDTO.setName(name);
        logger.info("Created Store {} with address {}", name, address);
        return storeDTO;
    }

    public TypeDTO createType(String typeName){
        TypeDTO typeDTO =new TypeDTO();
        typeDTO.setType(typeName);
        logger.info("Created new product's type: {}" , typeName);
        return  typeDTO;
    }

    public ProductDTO createProduct(){
        ProductDTORandomaizer productDTORandomaizer = new ProductDTORandomaizer();
        return  productDTORandomaizer.createDTO();
    }
}
