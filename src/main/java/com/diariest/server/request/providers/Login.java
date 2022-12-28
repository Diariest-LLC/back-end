package com.diariest.server.request.providers;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.diariest.server.database.Account;
import com.diariest.server.database.services.cassandra.AccountService;
import com.diariest.server.request.modules.RequestModule;
import org.json.JSONObject;
import org.springframework.web.socket.WebSocketSession;

public class Login extends RequestModule {

    public Login() {
        super(true, true, 1);
    }

    @Override
    public void response(WebSocketSession ctx, JSONObject msg, AccountService accountService) {
        JSONObject object = new JSONObject();
        object.put("message", "Giriş yaptın.");
        object.put("status", true);

        System.out.println(accountService);

        Account account = new Account();
        account.setId(Uuids.timeBased());
        account.setName("creax");
        account.setSurname("dilan");
        accountService.accountRepository.save(account);

        if(false) {
            error(ctx, "HATA");
            return;
        }

        success(ctx, object);
    }
}
