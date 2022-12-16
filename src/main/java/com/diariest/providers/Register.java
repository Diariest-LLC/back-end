package com.diariest.providers;

import com.diariest.providers.enums.RequestType;
import com.diariest.providers.module.RequestModule;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public class Register extends RequestModule {

    public Register() {
        super(RequestType.Register);
    }

    @Override
    public JSONObject onAction(ChannelHandlerContext ctx, Object msg) {
        JSONObject object = new JSONObject();
        object.put("data", "register");
        return object;
    }

}
