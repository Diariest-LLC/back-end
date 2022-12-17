package com.diariest.utils;

import com.diariest.providers.enums.ResponseErrorType;
import org.json.JSONObject;

public class UtilProvider {

    public static JSONObject error(ResponseErrorType type){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("requestType", "ERROR");
        jsonObject.put("value", type.toString());
        return jsonObject;
    }
}
