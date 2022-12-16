package com.diariest;

import com.diariest.netty.Netty;
import com.diariest.utilities.UtilConsole;

public class Main {

    public static final int PORT = 8282;
    public static Netty netty;

    public static void main(String[] args) {
        try {
            netty = new Netty();
        } catch (Exception e) {
            UtilConsole.log("Netty not started");
        }
    }
}