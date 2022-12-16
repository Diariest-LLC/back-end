package com.diariest.providers;

import com.diariest.providers.enums.RequestType;
import com.diariest.providers.module.RequestModule;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public class Login extends RequestModule {

    public Login() {
        super(RequestType.Login);
    }

    @Override
    public JSONObject onAction(ChannelHandlerContext ctx, Object msg) {
        JSONObject object = new JSONObject();
        object.put("data", "login");
        return object;
    }

}
