package com.diariest;

import com.diariest.providers.adapter.RequestAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.diariest.netty.Netty;
import com.diariest.utils.UtilConsole;

@SpringBootApplication
public class Main {

    public static final int PORT = 8282;
    public static Netty netty;

    public static void main(String[] args) {
        try {
            RequestAdapter.registerModules();

            SpringApplication.run(Main.class, args);
            netty = new Netty();
        } catch (Exception e) {
            UtilConsole.log("Netty not started.");
        }
    }
}