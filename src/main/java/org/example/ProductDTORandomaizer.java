package org.example;

import java.util.Random;

public class ProductDTORandomaizer {
    public void ProductDTORandomaizer(){

    }
    static Random random=new Random();
    public ProductDTO createDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(getRandomString());
        int randomType = (int)(1 + Math.random()*4);
        productDTO.setType(randomType);
        return productDTO;
    }

    public static String getRandomString(){
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
