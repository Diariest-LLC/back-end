package com.diariest.server;

import com.diariest.server.packet.PacketAdapter;
import com.diariest.server.request.RequestAdapter;
import com.diariest.server.database.Redis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.diariest.server.netty.Netty;
import com.diariest.server.utils.UtilConsole;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@SpringBootApplication
public class Main {

    private static ScheduledExecutorService executorService;
    private static Netty netty;
    private static Redis redis;

    public static void main(String[] args) {
        try {
            RequestAdapter.registerModules();
            PacketAdapter.enable();

            SpringApplication.run(Main.class, args);

            executorService = Executors.newSingleThreadScheduledExecutor();

            redis = new Redis();
            netty = new Netty();
        } catch (Exception e) {
            e.printStackTrace();
            UtilConsole.log("Netty server start error: " + e.getMessage());
        }
    }

    public static Redis getRedis() {
        return redis;
    }
    public static Netty getNetty() {
        return netty;
    }
    public static ScheduledExecutorService getExecutorService(){return executorService;}

}