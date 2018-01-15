package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private String userName;

    public Long getId() {

        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
