package com.diariest.server.response.models;

import org.json.JSONObject;

public class CustomDTO extends JSONObject {

    public CustomDTO(String requestName) {
        this.put("request_name", requestName);
    }

}
