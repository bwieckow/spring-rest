package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void add(Message message) {
        this.messageRepository.save(message);
    }

    @Override
    public List<Message> get() {
        return this.messageRepository.findAll();
    }

    @Override
    public void deleteAll() {
        this.messageRepository.deleteAll();
    }
}
