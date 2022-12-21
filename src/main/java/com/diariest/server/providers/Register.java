package com.diariest.server.providers;

import com.diariest.server.database.Redis;
import com.diariest.server.response.modules.RequestModule;
import com.diariest.server.utils.UtilConsole;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

import java.util.HashMap;

public class Register extends RequestModule {

    public Register() {
        super(false, 1);
    }

    @Override
    public void response(ChannelHandlerContext ctx, JSONObject msg) {
        JSONObject object = new JSONObject();
        object.put("data", new HashMap<>());
        object.put("status", true);

        JSONObject data = Redis.getData(msg.getString("username"));
        if(false) {
            error(ctx, object);
            return;
        }

        success(ctx, data);
    }
}
