package com.diariest.server.database.cassandra.models.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum FollowingType {

    DIARY(1),
    USER(2);

    private final int typeCode;

    FollowingType(int typeCode) {
        this.typeCode = typeCode;
    }

    public static FollowingType getFromTypeCode(int typeCode) {
        return Arrays.stream(FollowingType.values()).filter(type -> type.getTypeCode() == typeCode).findFirst().orElse(null);
    }

}
