package com.diariest.server.request.providers;

import com.diariest.server.database.adapters.ServiceAdapter;
import com.diariest.server.request.modules.RequestModule;
import com.diariest.server.utils.UtilEncrypt;
import org.json.JSONObject;
import org.springframework.web.socket.WebSocketSession;

public class Login extends RequestModule {

    public Login() {
        super(true, true, 1);
    }

    @Override
    public void response(WebSocketSession ctx, JSONObject msg, ServiceAdapter serviceAdapter) {
        JSONObject object = new JSONObject();

        object.put("private_key", UtilEncrypt.encrypt(msg.getString("password")));

        if(false) {
            error(ctx, "HATA");
            return;
        }

        success(ctx, object);
    }
}
