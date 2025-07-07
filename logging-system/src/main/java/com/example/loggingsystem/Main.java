package com.example.loggingsystem;

import com.example.loggingsystem.model.LogManager;

public class Main {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getInstance();
        logManager.debug("Hello World");
    }
}
