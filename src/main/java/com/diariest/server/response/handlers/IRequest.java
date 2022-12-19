package com.diariest.server.response.handlers;

import com.diariest.server.response.modules.ResponseObject;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public interface IRequest {

    void onAction(ChannelHandlerContext ctx, Object msg);
    void response(ChannelHandlerContext ctx, Object msg);
    void flush(ChannelHandlerContext ctx, ResponseObject object);
    void error(ChannelHandlerContext ctx, ResponseObject object);
    void success(ChannelHandlerContext ctx, ResponseObject object);
    void constantMessage(ChannelHandlerContext ctx, IMessageHandler message);
}
