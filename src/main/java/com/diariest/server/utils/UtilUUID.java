package com.diariest.server.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class UtilUUID {

    public static String createUUID(){
        return UUID.randomUUID().toString();
    }

    public static String createDifferentUUID() {
        String ts = String.valueOf(System.currentTimeMillis());
        String rand = UUID.randomUUID().toString();
        return DigestUtils.sha1Hex(ts + rand);
    }

}
