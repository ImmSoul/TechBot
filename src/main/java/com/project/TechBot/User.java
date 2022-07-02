package com.project.TechBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private SendMessage message;
    private String chatId;
    private String name;
    public boolean hasName = false;

    private String filial;
    public boolean hasFilial = false;

    public void setFilial(String filial) {
        this.filial = filial;
        this.hasFilial = true;
    }

    public User(String chatId) {
        this.chatId = chatId;

    }

    public void setName(String name) {
        this.name = name;
        this.hasName = true;
    }

    public String getName() {
        return name;
    }

    public String getChatId(){
        return chatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return chatId.equals(user.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId);
    }
}
