package com.diariest.providers;

import com.diariest.providers.enums.RequestType;
import com.diariest.providers.enums.ResponseErrorType;
import com.diariest.providers.module.RequestModule;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public class Login extends RequestModule {

    public Login() {
        super(RequestType.LOGIN);
    }

    @Override
    public void beforeResponse(ChannelHandlerContext context, Object msg) {
        JSONObject object = new JSONObject();
        object.put("data", "login");
        object.put("status", true);

        //SAMPLE ERROR USE
        if(false) {
            onError(context, ResponseErrorType.UNKNOWN);
            return;
        }

        response(context, object);
    }
}
