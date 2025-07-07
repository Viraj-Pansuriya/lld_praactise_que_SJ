package com.example.loggingsystem.utils;

import com.example.loggingsystem.model.DebugLogHandler;
import com.example.loggingsystem.model.ErrorLogHandler;
import com.example.loggingsystem.model.Handler;
import com.example.loggingsystem.model.InfoLogHandler;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LogUtils {

    public static Handler getLogger() {

        InfoLogHandler infoLogHandler = new InfoLogHandler(1);
        Handler debugLogHandler = new DebugLogHandler(2);
        Handler errorLogHandler = new ErrorLogHandler(3);

        infoLogHandler.setNextHandler(debugLogHandler);
        debugLogHandler.setNextHandler(errorLogHandler);
        return infoLogHandler;
    }
}
