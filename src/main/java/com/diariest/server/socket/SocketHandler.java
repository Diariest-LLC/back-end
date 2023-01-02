package com.diariest.server.socket;

import com.diariest.server.database.adapters.ServiceAdapter;
import com.diariest.server.request.RequestAdapter;
import com.diariest.server.request.modules.RequestModule;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Arrays;
import java.util.List;

@Component
public class SocketHandler extends TextWebSocketHandler {

    public static List<String> requiredData = Arrays.asList(
            "request_type"
    );

    @Autowired
    private ServiceAdapter serviceAdapter;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        JSONObject data;
        try {
            data = new JSONObject(payload);
            for(String required : requiredData) {
                data.get(required);
            }
        } catch (Exception ex) {
            return;
        }

        RequestModule requestModule = RequestAdapter.getModule(data.get("request_type").toString());
        if(requestModule == null) return;

        requestModule.onAction(session, data, serviceAdapter);
    }

}
