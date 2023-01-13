package com.diariest.server.request.handlers;

import com.diariest.server.adapters.ServiceAdapter;
import com.diariest.server.response.handlers.IMessageHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.socket.WebSocketSession;

public interface IRequest {

    void onAction(WebSocketSession ctx, JSONObject msg, ServiceAdapter serviceAdapter);
    void response(WebSocketSession ctx, JSONObject msg, ServiceAdapter serviceAdapter) throws JSONException;
    void flush(WebSocketSession ctx, Object object);
    void error(WebSocketSession ctx, Object object);
    void success(WebSocketSession ctx, Object object);
    void constantMessage(WebSocketSession ctx, IMessageHandler message);
}
