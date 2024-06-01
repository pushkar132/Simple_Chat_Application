package com.projects.chatApp.controller;

import com.projects.chatApp.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    // to connect with server : /server1
    // to send message : /app/message
    // subscribe to receive messages : /topic/return-to

    @SendTo("/topic/return-to")
    @MessageMapping("/message")
    public Message getContent(@RequestBody Message message){
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return message;
    }
}
