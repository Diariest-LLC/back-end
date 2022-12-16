package com.diariest.providers.handler;

import io.netty.channel.ChannelHandlerContext;
import org.json.JSONObject;

public interface IRequest {

    JSONObject onAction(ChannelHandlerContext ctx, Object msg);
}
