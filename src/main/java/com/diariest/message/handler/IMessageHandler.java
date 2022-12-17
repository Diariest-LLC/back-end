package com.diariest.message.handler;

public interface IMessageHandler {

    int getStatusCode();
    String getMessage();
    boolean isError();

}
