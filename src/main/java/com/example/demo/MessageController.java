package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(path = "/displayAll")
    public
    @ResponseBody
    List<Message> displayMessage() {
        return this.messageService.get();
    }

    @PostMapping(path = "/deleteHistory")
    public
    @ResponseBody
    String deleteHistory() {
        this.messageService.deleteAll();

        return "HISTORY DELETED";
    }

    @PostMapping(path = "/send")
    public
    @ResponseBody
    String send(@RequestParam String message,
                @RequestParam String userName) {
        Message newMessage = new Message();
        newMessage.setText(userName + ": " + message);

        this.messageService.add(newMessage);

        return "MESSAGE SENT";
    }

    @RequestMapping(path = "/sendJSON", method = RequestMethod.POST) // Map ONLY POST Requests
    public
    @ResponseBody
    void sendJSON(@RequestBody Message message) {
        messageService.add(message);
    }

}
