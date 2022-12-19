package com.diariest.server.providers;

import com.diariest.server.response.enums.RequestType;
import com.diariest.server.response.modules.RequestModule;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

import java.util.HashMap;

public class Register extends RequestModule {

    public Register() {
        super(RequestType.REGISTER);
    }

    @Override
    public void response(ChannelHandlerContext ctx, Object msg) {
        JSONObject object = new JSONObject();
        object.put("data", new HashMap<>());
        object.put("status", true);

        /*if(false) {
            error(ctx, object);
            return;
        }

        success(ctx, object);*/
    }
}
