package com.diariest.server.utils;

import com.google.gson.Gson;
import org.json.JSONObject;

public class UtilJSON {

    public static <T> JSONObject convertFromModel(T model) {
        Gson gson = new Gson();
        String convertedData = gson.toJson(model);
        return new JSONObject(convertedData);

    }

}
