package com.diariest.server.netty.handler;

import com.diariest.server.adapters.RequestAdapter;
import com.diariest.server.response.enums.RequestType;
import com.diariest.server.response.modules.RequestModule;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.json.JSONObject;

import java.util.ConcurrentModificationException;

public class WebSocketHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if(!(msg instanceof TextWebSocketFrame)) return;

        JSONObject data;
        try {
            data = new JSONObject(((TextWebSocketFrame) msg).text());
        } catch (Exception exception) {
            return;
        }

        RequestType requestType = RequestType.getRequestType(data.get("requestType").toString());
        if(requestType == null) return;

        RequestAdapter.getModule(requestType).onAction(ctx, msg);
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
