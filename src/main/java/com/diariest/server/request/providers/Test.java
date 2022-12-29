package com.diariest.server.request.providers;

import com.diariest.server.database.services.ServiceAdapter;
import com.diariest.server.request.modules.RequestModule;
import org.json.JSONObject;
import org.springframework.web.socket.WebSocketSession;

public class Test extends RequestModule {

    public Test() {
        super(true, false, 1);
    }

    @Override
    public void response(WebSocketSession ctx, JSONObject msg, ServiceAdapter serviceAdapter) {
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
