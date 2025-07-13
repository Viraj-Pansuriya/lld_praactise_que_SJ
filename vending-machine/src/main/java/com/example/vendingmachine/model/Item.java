package com.example.vendingmachine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int price;
    private int quantity;
    private ItemType itemType;

    public void reduceQuantity(){
        quantity--;
    }
}
