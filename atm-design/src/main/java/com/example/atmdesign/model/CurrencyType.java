package com.example.atmdesign.model;

import lombok.Getter;

public enum CurrencyType {
    TWO_THOUSAND(2000),
    FIVE_HUNDRED(500),
    HUNDRED(100),
    FIFTY(50),
    TWENTY(20),
    TEN(10);

    @Getter
    private final int value;
    CurrencyType(int value) {
        this.value = value;
    }
}
