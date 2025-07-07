package com.example.loggingsystem.model;

import lombok.Data;

@Data
public class ChainRequest {
    private int logLevel;
    private String message;
}
