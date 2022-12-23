package com.diariest.server.request.modules;

import com.diariest.server.packet.PacketAdapter;
import com.diariest.server.adapters.SessionAdapter;
import com.diariest.server.response.ResponseDataAdapter;
import com.diariest.server.response.constants.ErrorMessage;
import com.diariest.server.response.handlers.IMessageHandler;
import com.diariest.server.request.handlers.IRequest;
import com.diariest.server.utils.UtilConsole;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.concurrent.Callable;

@AllArgsConstructor
@Getter
@Setter
public abstract class RequestModule implements IRequest {

    private boolean sync;
    private boolean session;
    private int orderId;

    @Override
    public void error(ChannelHandlerContext ctx, Object object) {
        flush(ctx, ResponseDataAdapter.errorData(object));
    }

    @Override
    public void success(ChannelHandlerContext ctx, Object object) {
        flush(ctx, ResponseDataAdapter.successData(object));
    }

    @Override
    public void constantMessage(ChannelHandlerContext ctx, IMessageHandler message) {
        flush(ctx, ResponseDataAdapter.constantMessage(message));
    }

    @Override
    public void flush(ChannelHandlerContext ctx, Object object){
        ctx.writeAndFlush(new TextWebSocketFrame(object.toString()));
    }

    @Override
    public void onAction(ChannelHandlerContext ctx, JSONObject msg) {
        if(session) {
            if(!SessionAdapter.checkSession(msg)) {
                constantMessage(ctx, ErrorMessage.NO_SESSION_DATA);
                return;
            }
        }

        if(sync){
            PacketAdapter.addRequestQueue(() -> {
                if(orderId == -1) response(ctx, msg);
                else PacketAdapter.addOrderQueue(orderId, new Callable() {
                    @Override
                    public Object call() throws Exception {
                        response(ctx, msg);
                        return null;
                    }
                });
            });
            return;
        }

        response(ctx, msg);
    }

}
