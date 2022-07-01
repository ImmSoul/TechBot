package com.project.TechBot;

import java.util.Objects;

public class User {
    private String chatId;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return chatId.equals(user.chatId) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, name);
    }
}
