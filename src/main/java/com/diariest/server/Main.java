package com.diariest.server;

import com.diariest.server.adapters.PacketAdapter;
import com.diariest.server.adapters.RequestAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.diariest.server.netty.Netty;
import com.diariest.server.utils.UtilConsole;

@SpringBootApplication
public class Main {

    public static final int PORT = 8282;
    public static Netty netty;

    public static void main(String[] args) {
        try {
            RequestAdapter.registerModules();
            PacketAdapter.enable();

            SpringApplication.run(Main.class, args);
            netty = new Netty();
        } catch (Exception e) {
            UtilConsole.log("Netty not started.");
        }
    }
}