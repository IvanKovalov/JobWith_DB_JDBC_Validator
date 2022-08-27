package org.example;

import org.example.DTO.StoreDTO;
import org.example.ownValidator.CheckItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCheckItem {

    @Test
    public void TestChecking() {
        CheckItem checkItem = new CheckItem();
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setName(" ");
        boolean checked = checkItem.check(storeDTO);
        assertEquals(true, checked);
    }
}
