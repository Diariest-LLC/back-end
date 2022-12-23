package com.diariest.server.adapters;

import org.json.JSONObject;

public class SessionAdapter {

    public static boolean checkSession(JSONObject data) {
        String session_id;
        String private_key;
        try {
            session_id = data.getString("session_id");
            private_key = data.getString("private_key");
        } catch (Exception ex) {
            return false;
        }

        //TODO

        return true;
    }

}
