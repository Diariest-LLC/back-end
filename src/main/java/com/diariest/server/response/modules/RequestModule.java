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

@AllArgsConstructor
@Getter
@Setter
public abstract class RequestModule implements IRequest {

    private RequestType requestType;

    @Override
    public void error(ChannelHandlerContext ctx, ResponseObject object) {
        flush(ctx, object.apply(-1, true, ResponseDataType.MESSAGE));
    }

    @Override
    public void success(ChannelHandlerContext ctx, ResponseObject object) {
        flush(ctx, object.apply(1, false, ResponseDataType.DATA));
    }

    @Override
    public void constantMessage(ChannelHandlerContext ctx, IMessageHandler message) {
        flush(ctx, new ResponseObject().apply(message.getStatusCode(), message.isError(), ResponseDataType.MESSAGE));
    }

    @Override
    public void flush(ChannelHandlerContext ctx, ResponseObject object){
        ctx.writeAndFlush(new TextWebSocketFrame(object.toString()));
    }

    @Override
    public void onAction(ChannelHandlerContext ctx, Object msg) {
        if(isSYNC()){
            PacketAdapter.addRequestQueue(() -> { response(ctx, msg); });
            return;
        }

        response(ctx, msg);
    }

    protected boolean isSYNC(){ return requestType.getPacketType().equals(PacketType.SYNC); }

}
