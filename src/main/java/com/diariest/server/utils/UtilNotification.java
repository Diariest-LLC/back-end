package com.diariest.server.utils;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

public class UtilNotification {

    public static void sendNotification(String tokenID, String title, String description){
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(description)
                        .build())
                .setToken(tokenID)
                .build();

        try{
            String response = FirebaseMessaging.getInstance().send(message);
            UtilConsole.log("Sended notification to " + tokenID);
        }catch(FirebaseMessagingException exception){
            UtilConsole.log("Error on send notification function " + tokenID);
        }
    }
}
