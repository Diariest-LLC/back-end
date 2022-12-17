package com.diariest.server.response;

import com.diariest.server.response.enums.ResponseDataType;
import com.diariest.server.response.modules.ResponseData;
import com.diariest.server.utils.UtilJSON;
import org.json.JSONObject;

public class ResponseDataProvider {

    public static JSONObject successData(Object data) {
        if(data instanceof JSONObject);
        ResponseData responseData = new ResponseData(1, false, ResponseDataType.DATA.name(), data);
        return UtilJSON.convertFromModel(responseData);
    }

}
