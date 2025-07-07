package com.example.loggingsystem.model;

import lombok.Setter;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public abstract class Handler {

    @Setter
    private Handler nextHandler;
    private int level;

    public Handler(int level) {
        this.level = level;
    }

    void handle(String message , int messageLevel) {

        if(this.level <= messageLevel){
            logMessage(message);
        }
        if(nextHandler != null)
            this.nextHandler.handle(message, messageLevel);
    }

    protected abstract void logMessage(String message);

}
