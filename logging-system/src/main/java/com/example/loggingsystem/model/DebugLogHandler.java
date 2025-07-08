package com.example.loggingsystem.model;

public class DebugLogHandler extends Handler{
    public DebugLogHandler(int level) {
        super(level);
    }

    @Override
    protected void logMessage(String message) {
        System.out.println("[DEBUG] " + message);
    }
}
