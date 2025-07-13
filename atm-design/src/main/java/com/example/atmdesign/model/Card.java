package com.example.atmdesign.model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Card {
    private String cardNumber;
    private String bankName;
    private int pin;
    private String holderName;
    private LocalDateTime expiryDate;
}
