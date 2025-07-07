package com.example.loggingsystem.model;

import com.example.loggingsystem.utils.LogUtils;

public class LogManager {

    private final Handler handler;
    private static LogManager instance;

    private LogManager() {
        this.handler = LogUtils.getLogger();
    }

    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }


    public void info(String message) {
        handler.handle(message , 1);
    }

    public void error(String message) {
        handler.handle(message , 3);
    }

    public void debug(String message) {
        handler.handle(message , 2);
    }
}
