package com.diariest.types;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum RequestType {

    Login("Login", 1),
    Register("Register", 2),
    Session("Session", 3);

    private String requestName;
    private int index;

    RequestType(String requestName, int index) {
        this.requestName = requestName;
        this.index = index;
    }

    public static RequestType getRequestType(String requestName) {
        return Arrays.stream(RequestType.values()).filter(type -> type.getRequestName().equalsIgnoreCase(requestName)).findFirst().orElse(null);
    }

    public static RequestType getRequestType(int index) {
        return Arrays.stream(RequestType.values()).filter(type -> type.getIndex() == index).findFirst().orElse(null);
    }

}
