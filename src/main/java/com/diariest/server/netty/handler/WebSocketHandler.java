package com.diariest.server.netty.handler;

import com.diariest.server.request.RequestAdapter;
import com.diariest.server.request.modules.RequestModule;
import com.diariest.server.request.providers.Login;
import com.diariest.server.request.providers.Test;
import com.diariest.server.utils.UtilConsole;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

public class WebSocketHandler extends ChannelInboundHandlerAdapter {

    public static List<String> requiredData = Arrays.asList(
            "request_type"
    );

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if(!(msg instanceof TextWebSocketFrame)) return;

        JSONObject data;
        try {
            data = new JSONObject(((TextWebSocketFrame) msg).text());
        } catch (Exception ex) {
            return;
        }

        for(String required : requiredData) {
            try {
                data.get(required);
            } catch (Exception ex) {
                return;
            }
        }

        RequestModule requestModule = RequestAdapter.getModule(data.get("request_type").toString());
        if(requestModule == null) return;

        requestModule.onAction(ctx, data);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e){
        if(e instanceof ConcurrentModificationException) return;
        if(e.getMessage().contains("Connection reset by peer")) ctx.channel().close();
    }
}
