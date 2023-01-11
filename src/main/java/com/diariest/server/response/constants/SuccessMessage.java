package com.diariest.server.response.constants;

import com.diariest.server.response.handlers.IMessageHandler;

public enum SuccessMessage implements IMessageHandler {

    LOGIN(
            101,
            "Successfully logged in."
    ),
    REGISTER(
            102,
            "Successfully registered."
    );

    private final int successCode;
    private final String successMessage;

    SuccessMessage(int successCode, String successMessage) {
        this.successCode = successCode;
        this.successMessage = successMessage;
    }

    @Override
    public int getStatusCode() {
        return this.successCode;
    }

    @Override
    public String getMessage() {
        return this.successMessage;
    }

    @Override
    public boolean isError() {
        return true;
    }
}