package com.diariest.server.request.providers;

import com.diariest.server.adapters.ServiceAdapter;
import com.diariest.server.database.postgre.models.User;
import com.diariest.server.database.postgre.services.UserService;
import com.diariest.server.request.modules.RequestModule;
import com.diariest.server.response.constants.ErrorMessage;
import com.diariest.server.response.constants.SuccessMessage;
import com.diariest.server.utils.UtilEncrypt;
import com.diariest.server.utils.UtilUUID;
import org.json.JSONObject;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.Date;

public class Register extends RequestModule {

    public Register() {
        super(
                false,
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

        UserService userService = serviceAdapter.getUserService();
        if(userService.existsUserByNickName(nickName)) {
            constantMessage(ctx, ErrorMessage.USER_NICKNAME_ALREADY_USE);
            return;
        }
        if(userService.existsUserByEmail(email)) {
            constantMessage(ctx, ErrorMessage.EMAIL_ALREADY_USE);
            return;
        }
        if(userService.existsUserByPhoneNumber(phoneNumber)) {
            constantMessage(ctx, ErrorMessage.PHONE_NUMBER_ALREADY_USE);
            return;
        }

        User user = new User();
        user.setUserId(UtilUUID.createDifferentUUID());
        user.setNickName(nickName);
        user.setPassword(UtilEncrypt.encrypt(password));
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setVisibleName(visibleName);

        user.setMacIds(new ArrayList<>());
        user.addSavedMacId(macId);

        user.setBirthDate(new Date(birthDate));
        user.setCreatedAt(new Date(createdDate));

        constantMessage(ctx, SuccessMessage.REGISTER);
    }

}
