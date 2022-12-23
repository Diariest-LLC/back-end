package com.diariest.server.response.modules;

import com.diariest.server.adapters.PacketAdapter;
import com.diariest.server.response.ResponseDataProvider;
import com.diariest.server.response.enums.PacketType;
import com.diariest.server.response.enums.ResponseDataType;
import com.diariest.server.response.handlers.IMessageHandler;
import com.diariest.server.response.handlers.IRequest;
import com.diariest.server.response.enums.RequestType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.concurrent.Callable;

@Getter
@Setter
public abstract class RequestModule implements IRequest {

    private boolean sync = false;
    private int orderId = -1;

    public RequestModule(boolean sync){
        this(sync, -1);
    }

    public RequestModule(boolean sync, int orderId){
        this.sync = sync;
        this.orderId = orderId;
    }
    @Override
    public void error(ChannelHandlerContext ctx, Object object) {
        flush(ctx, ResponseDataProvider.errorData(object));
    }

    @Override
    public void success(ChannelHandlerContext ctx, Object object) {
        flush(ctx, ResponseDataProvider.successData(object));
    }

    @Override
    public void constantMessage(ChannelHandlerContext ctx, IMessageHandler message) {
        flush(ctx, ResponseDataProvider.constantMessage(message));
    }

    @Override
    public void flush(ChannelHandlerContext ctx, Object object){
        ctx.writeAndFlush(new TextWebSocketFrame(object.toString()));
    }

    @Override
    public void onAction(ChannelHandlerContext ctx, JSONObject msg) {
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
