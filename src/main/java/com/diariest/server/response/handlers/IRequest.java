package com.diariest.server.response.handlers;

import com.diariest.server.response.enums.ResponseErrorType;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public interface IRequest {

    void onAction(ChannelHandlerContext context, Object msg);
    void onError(ChannelHandlerContext context, ResponseErrorType errorType);

    void response(ChannelHandlerContext context, Object msg);

    void flush(ChannelHandlerContext context, JSONObject object);
}
