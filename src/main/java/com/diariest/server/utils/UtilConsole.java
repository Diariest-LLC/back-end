package com.diariest.server.utils;

import com.diariest.server.Configuration;

public class UtilConsole {

    public static void log(String message){
        System.out.println(Configuration.PROJECT_NAME + " - " + message);
    }

}
