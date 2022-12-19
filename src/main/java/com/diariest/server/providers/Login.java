package com.diariest.server.providers;

import com.diariest.server.response.enums.RequestType;
import com.diariest.server.response.modules.RequestModule;
import com.diariest.server.response.modules.ResponseObject;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public class Login extends RequestModule {

    public Login() {
        super(RequestType.LOGIN);
    }

    @Override
    public void response(ChannelHandlerContext ctx, Object msg) {
        ResponseObject object = new ResponseObject();
        object.put("requestType", "login");
        object.put("status", true);

        //SAMPLE ERROR USE
        if(false) {
            error(ctx, object);
            return;
        }

        success(ctx, object);
    }
}
