package com.example.demo;

import java.util.List;

interface MessageService {

    void add(Message message);

    List<Message> get();

    void deleteAll();
}
