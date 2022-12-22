package com.diariest.server;

import com.diariest.server.adapters.PacketAdapter;
import com.diariest.server.adapters.RequestAdapter;
import com.diariest.server.database.Redis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.diariest.server.netty.Netty;
import com.diariest.server.utils.UtilConsole;

@SpringBootApplication
public class Main {

    private static Netty netty;

    private static Redis redis;

    public static void main(String[] args) {
        try {
            RequestAdapter.registerModules();
            PacketAdapter.enable();

            SpringApplication.run(Main.class, args);

            redis = new Redis();
            netty = new Netty();
        } catch (Exception e) {
            e.printStackTrace();
            UtilConsole.log("Netty sunucusu aktifleştirilemedi. " + e.getMessage());
        }
    }

    public static Redis getRedis() {
        return redis;
    }

    public static Netty getNetty() {
        return netty;
    }

}