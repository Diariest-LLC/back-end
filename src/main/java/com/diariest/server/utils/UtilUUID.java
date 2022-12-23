package com.diariest.server.utils;

import java.util.UUID;

public class UtilUUID {

    public static String createUUID(){
        return UUID.randomUUID().toString();
    }
}
