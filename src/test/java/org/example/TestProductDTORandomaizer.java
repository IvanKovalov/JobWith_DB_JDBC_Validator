package org.example;

import org.example.DTO.ProductDTO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestProductDTORandomaizer {
    ProductDTORandomaizer productDTORandomaizer = new ProductDTORandomaizer();

    @Test
    public void TestGetRandomString (){
        String actualString = productDTORandomaizer.getRandomString();
        assertNotNull("Failed TestGetRandomString",actualString);
        assertTrue(productDTORandomaizer.getRandomString() instanceof String);

    }

    @Test
    public void TestCreateRandomDTO () {
        ProductDTO productDTO = productDTORandomaizer.createDTO();
        assertNotNull("Failed TestCreateRandomDTO",productDTO.getType());
        assertNotNull("Failed TestCreateRandomDTO",productDTO.getName());
    }
}
