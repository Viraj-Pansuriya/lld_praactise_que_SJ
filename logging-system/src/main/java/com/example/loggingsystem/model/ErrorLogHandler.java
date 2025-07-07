package com.example.loggingsystem.model;

public class ErrorLogHandler extends Handler{
    public ErrorLogHandler(int level) {
        super(level);
    }

    @Override
    protected void logMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
