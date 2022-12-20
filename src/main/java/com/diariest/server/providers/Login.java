package com.diariest.server.providers;

import com.diariest.server.response.modules.RequestModule;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public class Login extends RequestModule {

    public Login() {
        super(true, 1);
    }

    @Override
    public void response(ChannelHandlerContext ctx, Object msg) {
        JSONObject object = new JSONObject();
        object.put("data", "login");
        object.put("status", true);

        //SAMPLE ERROR USE
        if(false) {
            error(ctx, object);
            return;
        }

        success(ctx, object);
    }
}
