package com.project.TechBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    private String name = "TechnicsSS_bot";
    private String botToken = "5402567174:AAHcNymnlIrUUJfNXOQjz_8MTaXVEf71BmM";




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

    }
}
