package com.diariest;

import com.diariest.providers.AccountProvider;
import com.diariest.providers.RequestResponse;
import com.diariest.types.RequestType;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.diariest.netty.Netty;
import com.diariest.utils.UtilConsole;

import java.util.HashMap;

@SpringBootApplication
public class Main {

    public static HashMap<RequestType, RequestResponse> responses = new HashMap<>();

    public static final int PORT = 8282;
    public static Netty netty;

    public static void main(String[] args) {
        try {
            SpringApplication.run(Main.class, args);
            netty = new Netty();
        } catch (Exception e) {
            UtilConsole.log("Netty not started.");
        }

        RequestResponse accountResponse = new RequestResponse(RequestType.Login) {
            @Override
            public JSONObject onAction() {
                return AccountProvider.getAccountData();
            }
        };

        responses.put(RequestType.Login, accountResponse);
    }
}