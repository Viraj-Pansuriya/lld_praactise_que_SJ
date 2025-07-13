package com.example.vendingmachine.model;

import lombok.Getter;

public enum Coin {
    ONE_RUPEE(1),
    FIVE_RUPEE(5),
    TEN_RUPEE(10),
    FIFTY_RUPEE(50);

    @Getter
    private final int value;
    Coin(int value) {
        this.value = value;
    }
}
