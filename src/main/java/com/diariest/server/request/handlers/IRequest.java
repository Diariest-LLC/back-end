package com.diariest.server.request.handlers;

import com.diariest.server.response.handlers.IMessageHandler;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;
import org.springframework.web.socket.WebSocketSession;

public interface IRequest {

    void onAction(WebSocketSession ctx, JSONObject msg);
    void response(WebSocketSession ctx, JSONObject msg);
    void flush(WebSocketSession ctx, Object object);
    void error(WebSocketSession ctx, Object object);
    void success(WebSocketSession ctx, Object object);
    void constantMessage(WebSocketSession ctx, IMessageHandler message);
}
