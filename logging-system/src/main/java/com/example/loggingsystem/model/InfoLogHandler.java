package com.example.loggingsystem.model;

public class InfoLogHandler extends Handler{


    public InfoLogHandler(int level) {
        super(level);
    }

    @Override
    protected void logMessage(String message) {
        System.out.println("INFO: " + message);
    }
}
