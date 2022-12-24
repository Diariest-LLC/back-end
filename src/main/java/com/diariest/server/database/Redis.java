package com.diariest.server.database;

import com.diariest.server.Configuration;
import com.diariest.server.Main;
import com.diariest.server.utils.UtilConsole;
import org.json.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class Redis {

    private Jedis jedis;

    public Redis() {
        if(createConnection()) UtilConsole.log("Redis bağlantısı kuruldu!");
    }

    public Jedis getConnection() {
        return this.jedis;
    }

    private boolean createConnection() {
        try {
            jedis = new Jedis(Configuration.REDIS_HOST, Configuration.REDIS_PORT);
            jedis.select(0);
            return true;
        } catch (JedisException jedisException) {
            UtilConsole.log("Redis bağlantısı kurulamadı. " + jedisException.getMessage());
        }
        return false;
    }

    public static boolean setData(String key, Object data) {
        try {
            Main.getRedis().getConnection().set(key, data.toString());
            Main.getRedis().getConnection().pexpireAt(key, System.currentTimeMillis() + 5000000);
            return true;
        } catch(Exception exception) {
            return false;
        }
    }

    /*public static JSONObject getData(String key) {
        String data = Main.getRedis().getConnection().get(key);
        return new JSONObject(data);
    }*/

    public static Object getData(String key) {
        return Main.getRedis().getConnection().get(key);
    }

    public static boolean deleteData(String key) {
        Main.getRedis().getConnection().del(key);
        return true;
    }

}
