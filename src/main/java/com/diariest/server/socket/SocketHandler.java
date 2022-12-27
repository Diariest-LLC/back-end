package com.diariest.server.socket;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.diariest.server.database.Account;
import com.diariest.server.database.repositories.cassandra.AccountRepository;
import com.diariest.server.utils.UtilConsole;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Arrays;
import java.util.List;

@Component
public class SocketHandler extends TextWebSocketHandler {

    public static List<String> requiredData = Arrays.asList(
            "request_type"
    );

    @Autowired
    private AccountRepository accountRepository;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Account account = new Account();
        account.setId(Uuids.timeBased());
        account.setName("ferhat");
        account.setSurname("erdem");
        accountRepository.save(account);

        UtilConsole.log(payload);
        session.sendMessage(new TextMessage("ss"));
    }

}
