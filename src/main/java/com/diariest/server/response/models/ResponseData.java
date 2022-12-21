package com.diariest.server.response.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@Accessors
public class ResponseData {

    private int statusCode;
    private boolean error;
    private Object ctx;
    private Object data;

}
