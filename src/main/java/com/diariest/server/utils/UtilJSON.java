package com.diariest.server.utils;

import com.google.gson.Gson;
import org.json.JSONObject;

public class UtilJSON {

    public static JSONObject convertFromModel(Object model) {
        return new JSONObject(new Gson().toJson(model));
    }

}
