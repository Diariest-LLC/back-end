package com.diariest.providers.handler;

import com.diariest.providers.enums.ResponseErrorType;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public interface IRequest {

    void onAction(ChannelHandlerContext context, Object msg);
    void onError(ChannelHandlerContext context, ResponseErrorType errorType);

    void beforeResponse(ChannelHandlerContext context, Object msg);

    void response(ChannelHandlerContext context, JSONObject object);
}
