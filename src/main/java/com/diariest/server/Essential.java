package com.diariest.server;

import com.diariest.server.adapters.PacketAdapter;
import com.diariest.server.database.Redis;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.diariest.server.netty.Netty;
import com.diariest.server.utils.UtilConsole;

@SpringBootApplication
public class Essential {

    public static Netty netty;

    private static Redis redis;

    public static void enable(){
        try {
            PacketAdapter.enable();
            redis = new Redis();
            netty = new Netty();
        } catch (Exception e) {
            UtilConsole.log("Netty sunucusu aktifleştirilemedi. " + e.getMessage());
        }
    }

    public static Redis getRedis() {
        return redis;
    }

}