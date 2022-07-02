package com.project.TechBot;

import java.util.Objects;

public class User {
    private String chatId;
    private String name;

    private String filial;

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public User(String chatId) {
        this.chatId = chatId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getChatId(){
        return chatId;
    }


}
