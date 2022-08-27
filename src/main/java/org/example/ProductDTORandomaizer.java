package org.example;

import org.example.DTO.ProductDTO;
import org.example.ownValidator.CheckItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ProductDTORandomaizer {
    public void ProductDTORandomaizer(){

    }
    static Random random=new Random();
    int amountProduct = 0;

    Logger logger = LoggerFactory.getLogger(ProductDTORandomaizer.class);
    public ProductDTO createDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(getRandomString());
        int randomType = (int)(1 + Math.random()*4);
        productDTO.setType(randomType);
        amountProduct ++;
        if (amountProduct == 10000){
            logger.info("Created every 10000 product {}", productDTO.getName());
            amountProduct = 0;
        }
        return productDTO;
    }

    public  String getRandomString(){
        int length = 40;
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
       return sb.toString();

    }
}
