package com.diariest.server.providers;

import com.diariest.server.database.Redis;
import com.diariest.server.response.modules.RequestModule;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public class Login extends RequestModule {

    public Login() {
        super(true, 1);
    }

    @Override
    public void response(ChannelHandlerContext ctx, JSONObject msg) {
        JSONObject object = new JSONObject();
        object.put("message", "Giriş yaptın.");
        object.put("status", true);

        boolean data = Redis.setData(msg.getString("username"), msg.getString("password"));
        if(!data) {
            error(ctx, "HATA");
            return;
        }

        success(ctx, object);
    }
}
