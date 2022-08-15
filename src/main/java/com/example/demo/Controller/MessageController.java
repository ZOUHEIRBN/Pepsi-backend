package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

import com.example.demo.Entity.Message;
import com.example.demo.Entity.ResponseMessage;
import com.example.demo.Services.NotificationService;

@Controller
public class MessageController {
    @Autowired
    private NotificationService notificationService;



    @MessageMapping("/message")
    @SendTo("/pepsi_rh/messages")
public ResponseMessage getMessage(final Message message) throws InterruptedException {
     Thread.sleep(1000);
     notificationService.sendGlobalNotification();
     return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
}

    @MessageMapping("/private-message")
    @SendToUser("/pepsi_rh/private-messages")
    public ResponseMessage getPrivateMessage(final Message message, final Principal principal) throws InterruptedException {
        Thread.sleep(1000);
        notificationService.sendPrivateNotification(principal.getName());
        return new ResponseMessage(HtmlUtils.htmlEscape("Sending Private message to User"  + principal.getName() + " : " + message.getMessageContent()));
    }
}