package com.diariest.server.response.modules;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Accessors
public class ResponseObject extends JSONObject {

    private int statusCode;
    private boolean error;
    private Object ctx;

    public ResponseObject apply(int statusCode, boolean error, Object ctx){

        return this;
    }
}
