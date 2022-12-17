package com.diariest.providers.module;

import com.diariest.providers.adapter.PacketAdapter;
import com.diariest.providers.enums.PacketType;
import com.diariest.providers.enums.ResponseErrorType;
import com.diariest.providers.handler.IRequest;
import com.diariest.providers.enums.RequestType;
import com.diariest.utils.UtilProvider;
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
    public void onError(ChannelHandlerContext context, ResponseErrorType errorType){
        flush(context, UtilProvider.error(errorType));
    }

    public void flush(ChannelHandlerContext context, JSONObject object){
        context.writeAndFlush(new TextWebSocketFrame(object.toString()));
    }

    @Override
    public void onAction(ChannelHandlerContext context, Object msg) {
        if(isSYNC()){
            PacketAdapter.addRequestQueue(() -> { response(context, msg); });
            return;
        }

        response(context, msg);
    }

    public boolean isSYNC(){ return requestType.getPacketType().equals(PacketType.SYNC); }

}
