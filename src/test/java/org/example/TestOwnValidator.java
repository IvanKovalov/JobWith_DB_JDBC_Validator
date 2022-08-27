package org.example;

import org.example.DTO.ProductDTO;
import org.example.DTO.StoreDTO;
import org.example.DTO.TypeDTO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestOwnValidator {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    final static Logger logger = LoggerFactory.getLogger(TestOwnValidator.class);

    @Test
    public void  TestStoreDTOName () {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setName("12FFF");
        storeDTO.setAddress("Popova 16");
        Set<ConstraintViolation<StoreDTO>> violations = validator.validate(storeDTO);
        assertEquals("StoreDTO's name has invalid characters", violations.iterator().next().getMessage());
        logger.info("TestStoreDTOName passed");
    }

    @Test
    public void TestStoreDTONotBlankAddress () {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setName("Epicentr");
        storeDTO.setAddress(" ");
        Set<ConstraintViolation<StoreDTO>> violations = validator.validate(storeDTO);
        assertEquals("Address can't be blank", violations.iterator().next().getMessage());
        logger.info("TestStoreDTONotBlankAddress passed");
    }

    @Test
    public void TestTypeDTONameInvalidCharacters () {
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setType("12priv)(");
        Set<ConstraintViolation<TypeDTO>> violations = validator.validate(typeDTO);
        assertEquals("TypeDTO's type has invalid characters", violations.iterator().next().getMessage());
        logger.info("TestTypeDTONameInvalidCharacters passed");
    }

    @Test
    public void TestTypeDTONameBlank () {
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setType(" ");
        Set<ConstraintViolation<TypeDTO>> violations = validator.validate(typeDTO);
        assertEquals("Type can't be empty", violations.iterator().next().getMessage());
        logger.info("TestTypeDTONameBlank passed");
    }

    @Test
    public void TestProductDTONameOnVowel () {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ourmd");
        productDTO.setType(1);
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertEquals("Invalid count of vowel symbol", violations.iterator().next().getMessage());
        logger.info("TestProductDTONameOnVowel passed");
    }

    @Test
    public void TestProductDTONameOnInvalidCharacters () {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ourmadtiny()++");
        productDTO.setType(1);
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertEquals("ProductDTO's name has invalid characters", violations.iterator().next().getMessage());
        logger.info("TestProductDTONameOnInvalidCharacters passed");
    }

    @Test
    public void TestProductDTONameOnLength () {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ourmadtiny123456789otfjsalsldosaldallsaodaofkjshfyhsdyhfehsfshnfhehsfdjnfsjejfshdjnfsjjasjd");
        productDTO.setType(1);
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertEquals("Invalid ProductDTO's Name, too many characters", violations.iterator().next().getMessage());
        logger.info("TestProductDTONameOnLength passed");
    }

    @Test
    public void TestProductDTOTypeLessThan1  () {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ourmadd");
        productDTO.setType(-1);
        Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);
        assertEquals("ProductDTO's type must be > 0", violations.iterator().next().getMessage());
        logger.info("TestProductDTOTypeLessThan1 passed");

    }


}
