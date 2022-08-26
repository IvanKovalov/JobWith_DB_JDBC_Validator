package org.example;

import javax.validation.constraints.*;

public class ProductDTO {
    private int productId;
    private String name;
    private int type;
    public void setProductId (int id){
        this.productId = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setType(int type) {
        this.type = type;
    }

    @NotBlank
    @Pattern(regexp = "[a-z-A-Z]*", message = "ProductDTO's name has invalid characters")
    public String getName() {
        System.out.println(this.name);
        return this.name;
    }

    @NotNull
    @Min(value = 0, message = "ProductDTO's type must be > 0")
    @Max(value = 5, message = "ProductDTO's type must be less than 5")
    public int getType() {
        return this.type;
    }

    public int getProductId() {
        return productId;
    }


}
