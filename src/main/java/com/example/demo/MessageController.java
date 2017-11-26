package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/message")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(path = "/send")
    public
    @ResponseBody
    String send(@RequestParam String message) {
        Message newMessage = new Message();
        newMessage.setText("WIADOMOSC: " + message);

        this.messageService.add(newMessage);

        return "MESSAGE SENT";
    }

    @GetMapping(path = "/displayAll")
    public
    @ResponseBody
    List<Message> displayMessage() {
        return this.messageService.get();
    }

    @GetMapping(path = "/deleteHistory")
    public
    @ResponseBody
    String deleteHistory() {
        this.messageService.deleteAll();

        return "HISTORY DELETED";
    }

}
