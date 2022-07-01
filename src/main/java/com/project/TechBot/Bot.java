package com.project.TechBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashSet;
import java.util.Set;

public class Bot extends TelegramLongPollingBot {
    private String name = "TechnicsSS_bot";
    private String botToken = "5402567174:AAHcNymnlIrUUJfNXOQjz_8MTaXVEf71BmM";

    Set<String> usersId = new HashSet<>();




    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String id = update.getMessage().getChatId().toString();
        if (!usersId.contains(id)) {

            usersId.add(id);
            SendMessage startMessage = new SendMessage(id, "Привет коллега! Что тебя привело в нашу обитель знаний?");

            try {
                execute(startMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }

        SendMessage startMessage = new SendMessage(id, "Выбери тему");
        startMessage.setReplyMarkup(new KeyBoardTable().getKeyBoardTable());
        try {
            execute(startMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
