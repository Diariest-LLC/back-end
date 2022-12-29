package com.diariest.server.request.providers;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.diariest.server.database.User;
import com.diariest.server.database.services.ServiceAdapter;
import com.diariest.server.database.services.cassandra.UserService;
import com.diariest.server.request.modules.RequestModule;
import org.json.JSONObject;
import org.springframework.web.socket.WebSocketSession;

public class Login extends RequestModule {

    public Login() {
        super(true, true, 1);
    }

    @Override
    public void response(WebSocketSession ctx, JSONObject msg, ServiceAdapter serviceAdapter) {
        JSONObject object = new JSONObject();
        object.put("message", "Giriş yaptın.");
        object.put("status", true);

        User user = new User();
        user.setId(Uuids.timeBased());
        user.setName("creax");
        user.setSurname("dilan");
        serviceAdapter.getUserService().saveAccount(user);

        if(false) {
            error(ctx, "HATA");
            return;
        }

        success(ctx, object);
    }
}
