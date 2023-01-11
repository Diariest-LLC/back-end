package com.diariest.server.request.providers;

import com.diariest.server.adapters.ServiceAdapter;
import com.diariest.server.request.modules.RequestModule;
import org.json.JSONObject;
import org.springframework.web.socket.WebSocketSession;

public class Login extends RequestModule {

    public Login() {
        super(
                true,
                false,
                true,
                1
        );
    }

    @Override
    public void response(WebSocketSession ctx, JSONObject msg, ServiceAdapter serviceAdapter) {
        JSONObject object = new JSONObject();

        if(false) {
            error(ctx, "HATA");
            return;
        }

        success(ctx, object);
    }
}
