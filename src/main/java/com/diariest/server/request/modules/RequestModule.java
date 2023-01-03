package com.diariest.server.request.modules;

import com.diariest.server.database.adapters.ServiceAdapter;
import com.diariest.server.adapters.PacketAdapter;
import com.diariest.server.adapters.SessionAdapter;
import com.diariest.server.response.ResponseDataAdapter;
import com.diariest.server.response.constants.ErrorMessage;
import com.diariest.server.response.handlers.IMessageHandler;
import com.diariest.server.request.handlers.IRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.Callable;

@AllArgsConstructor
@Getter
@Setter
public abstract class RequestModule implements IRequest {

    private boolean sync;
    private boolean session;
    private int orderId;

    @Override
    public void error(WebSocketSession ctx, Object object) {
        flush(ctx, ResponseDataAdapter.errorData(object));
    }

    @Override
    public void success(WebSocketSession ctx, Object object) {
        flush(ctx, ResponseDataAdapter.successData(object));
    }

    @Override
    public void constantMessage(WebSocketSession ctx, IMessageHandler message) {
        flush(ctx, ResponseDataAdapter.constantMessage(message));
    }

    @Override
    public void flush(WebSocketSession ctx, Object object){
        try {
            ctx.sendMessage(new TextMessage(object.toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onAction(WebSocketSession ctx, JSONObject msg, ServiceAdapter serviceAdapter) {
        if(session) {
            if(!SessionAdapter.checkSession(msg)) {
                constantMessage(ctx, ErrorMessage.NO_SESSION_DATA);
                return;
            }
        }

        if(sync){
            PacketAdapter.addRequestQueue(() -> {
                if(orderId == -1) response(ctx, msg, serviceAdapter);
                else PacketAdapter.addOrderQueue(orderId, new Callable() {
                    @Override
                    public Object call() throws Exception {
                        response(ctx, msg, serviceAdapter);
                        return null;
                    }
                });
            });
            return;
        }

        response(ctx, msg, serviceAdapter);
    }

}
