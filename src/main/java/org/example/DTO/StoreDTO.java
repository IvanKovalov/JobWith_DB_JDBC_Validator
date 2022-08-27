package org.example.DTO;



import org.example.ownValidator.Check;

import javax.validation.constraints.*;

public class StoreDTO {
    private int idStore;
    private String name;
    private String address;



    public void setName(String name) {
        this.name = name;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @NotBlank(message = "Name can't be empty")
    @Pattern(regexp = "[a-z-A-Z]*", message = "StoreDTO's name has invalid characters")
    public String getName() {
        return name;
    }

    public int getIdStore() {
        return idStore;
    }

    @NotBlank(message = "Address can't be empty")
    //@Pattern(regexp = "[a-z-A-Z-0-9]*", message = "StoreDTO's address has invalid characters")
    public String getAddress() {
        return address;
    }
}
