package com.diariest.server.response;

import com.diariest.server.response.enums.ResponseDataType;
import com.diariest.server.response.modules.ResponseData;
import com.diariest.server.utils.UtilJSON;
import com.google.gson.JsonParser;
import org.json.JSONObject;

public class ResponseDataProvider {

    public static JSONObject successData(Object data) {
        if(data instanceof JSONObject) data = new JsonParser().parse(data.toString()).getAsJsonObject();

        ResponseData responseData = new ResponseData(1, false, ResponseDataType.DATA.name(), data);
        return UtilJSON.convertFromModel(responseData);
    }

}
