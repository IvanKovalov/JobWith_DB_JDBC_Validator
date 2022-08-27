package org.example.DTO;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TypeDTO {
    private int idType;
    private String type;


    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setType(String type) {
        this.type = type;
    }

    //@Min(value = 1,message = "TypeDTO's ID can't be less than 1")
    public int getIdType() {
        return idType;
    }

    @NotBlank(message = "Type can't be empty")
    @Pattern(regexp = "[a-z-A-Z]*", message = "TypeDTO's type has invalid characters")
    public String getType() {
        return type;
    }
}
