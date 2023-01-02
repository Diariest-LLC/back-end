package com.diariest.server.database.cassandra.models.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PostType {

    IMAGE(1),
    VIDEO(2),
    TEXT(3),
    POLL(4);

    private final int typeCode;

    PostType(int typeCode) {
        this.typeCode = typeCode;
    }

    public static PostType getFromTypeCode(int typeCode) {
        return Arrays.stream(PostType.values()).filter(type -> type.getTypeCode() == typeCode).findFirst().orElse(null);
    }

}
