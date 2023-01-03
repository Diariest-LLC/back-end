package com.diariest.server;

import com.diariest.server.adapters.PacketAdapter;
import com.diariest.server.request.RequestAdapter;
import com.diariest.server.database.Redis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.diariest.server.utils.UtilConsole;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.diariest.server.database.postgre.repositories")
@EnableCassandraRepositories(basePackages = "com.diariest.server.database.cassandra.repositories")
public class Main {

    private static ScheduledExecutorService executorService;
    private static Redis redis;

    public static void main(String[] args) {
        try {
            SpringApplication.run(Main.class, args);
            RequestAdapter.registerModules();
            PacketAdapter.enable();

            executorService = Executors.newSingleThreadScheduledExecutor();
            redis = new Redis();
        } catch (Exception e) {
            UtilConsole.log("Socket server start error: " + e.getMessage());
        }
    }

    public static Redis getRedis() {
        return redis;
    }
    public static ScheduledExecutorService getExecutorService(){return executorService;}

}