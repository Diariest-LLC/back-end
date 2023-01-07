package com.diariest.server.request.providers;

import com.diariest.server.adapters.ServiceAdapter;
import com.diariest.server.database.postgre.models.User;
import com.diariest.server.request.modules.RequestModule;
import com.diariest.server.response.constants.ErrorMessage;
import com.diariest.server.utils.UtilEncrypt;
import com.diariest.server.utils.UtilUUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.socket.WebSocketSession;

import java.util.Date;

public class Register extends RequestModule {

    public Register() {
        super(
                true,
                false,
                false,
                1
        );
    }

    @Override
    public void response(WebSocketSession ctx, JSONObject msg, ServiceAdapter serviceAdapter) {
        String nickName = msg.getString("nickname");
        String password = msg.getString("password");
        String email = msg.getString("email");
        String phoneNumber = msg.getString("phone_number");
        String visibleName = msg.getString("visible_name");
        String macId = msg.getString("mac_id");
        long birthDate = msg.getLong("birth_date");
        long createdDate = System.currentTimeMillis();

        //security check.

        User user = new User();
        user.setUserId(UtilUUID.createDifferentUUID());
        user.setNickName(nickName);
        user.setPassword(UtilEncrypt.encrypt(password));
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setVisibleName(visibleName);
        user.addSavedMacId(macId);
        user.setBirthDate(new Date(birthDate));
        user.setCreatedAt(new Date(createdDate));

        success(ctx, "object");
    }

}
