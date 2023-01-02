package com.diariest.server.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilTime {

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Date parseDate(long timestamp) {
        return new Date(timestamp);
    }

}
