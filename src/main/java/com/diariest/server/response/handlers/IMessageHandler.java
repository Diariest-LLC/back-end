package com.diariest.server.response.handlers;

public interface IMessageHandler {

    int getStatusCode();
    String getMessage();
    boolean isError();

}
