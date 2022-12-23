package com.diariest.server.response.constants;

import com.diariest.server.response.handlers.IMessageHandler;

public enum ErrorMessage implements IMessageHandler {

    NO_SESSION_DATA(201, "Wrong session data.");

    private int errorCode;
    private String errorMessage;

    ErrorMessage(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getStatusCode() {
        return this.errorCode;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }

    @Override
    public boolean isError() {
        return true;
    }
}
