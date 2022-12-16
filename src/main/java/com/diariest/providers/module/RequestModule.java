package com.diariest.providers.module;

import com.diariest.providers.handler.IRequest;
import com.diariest.providers.enums.RequestType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class RequestModule implements IRequest {

    private RequestType requestType;

}
