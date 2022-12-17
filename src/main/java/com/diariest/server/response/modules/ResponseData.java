package com.diariest.server.response.modules;

import com.diariest.server.response.enums.ResponseDataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors
public class ResponseData<T> {

    private int statusCode;
    private boolean error;
    private ResponseDataType ctx;
    private T data;

}
