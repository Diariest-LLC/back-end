package com.diariest.server.response.handlers;

import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public interface IRequest {

    void onAction(ChannelHandlerContext ctx, JSONObject msg);
    void response(ChannelHandlerContext ctx, JSONObject msg);
    void flush(ChannelHandlerContext ctx, Object object);
    void error(ChannelHandlerContext ctx, Object object);
    void success(ChannelHandlerContext ctx, Object object);
    void constantMessage(ChannelHandlerContext ctx, IMessageHandler message);
}
