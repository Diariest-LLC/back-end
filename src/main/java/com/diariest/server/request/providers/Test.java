package com.diariest.server.request.providers;

import com.diariest.server.request.modules.RequestModule;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public class Test extends RequestModule {

    public Test() {
        super(true, false, 1);
    }

    @Override
    public void response(ChannelHandlerContext ctx, JSONObject msg) {
        JSONObject object = new JSONObject();
        object.put("message", "Giriş yaptın.");
        object.put("status", true);

        if(false) {
            error(ctx, "HATA");
            return;
        }

        success(ctx, object);
    }

}
