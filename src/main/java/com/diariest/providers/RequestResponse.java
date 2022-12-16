package com.diariest.providers;

import com.diariest.types.RequestType;
import org.json.JSONObject;

public abstract class RequestResponse extends ResponseBase implements IRequest{

    public RequestResponse(RequestType type){
        this.type = type;
    }
}
