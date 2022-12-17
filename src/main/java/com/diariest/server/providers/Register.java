package com.diariest.server.providers;

import com.diariest.server.databases.models.Test;
import com.diariest.server.response.ResponseDataProvider;
import com.diariest.server.response.enums.RequestType;
import com.diariest.server.response.enums.ResponseErrorType;
import com.diariest.server.response.modules.RequestModule;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public class Register extends RequestModule {

    public Register() {
        super(RequestType.REGISTER);
    }

    @Override
    public void response(ChannelHandlerContext context, Object msg) {
        if(false) {
            onError(context, ResponseErrorType.UNKNOWN);
            return;
        }
        JSONObject object = new JSONObject();
        object.put("data", "login");
        object.put("status", true);


        flush(context, ResponseDataProvider.successData(object));
    }
}
