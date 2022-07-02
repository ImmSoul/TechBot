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
            SendMessage autoryMessage = new SendMessage(id, BotDialogs.START_DIALOG.getDialog());
            User user = new User(id);

            try {
                execute(autoryMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            autoryMessage.setText(BotDialogs.START_NAME.getDialog());
            try {
                execute(autoryMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

            user.setName(update.getMessage().toString());
            System.out.println("Added new name " + user.getName().toString());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            autoryMessage.setText(BotDialogs.START_FILIAL.getDialog());
            try {
                execute(autoryMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

            user.setName(update.getMessage().toString());
            System.out.println("Added new FILIAL " + user.getName().toString());

        }

//        SendMessage startMessage = new SendMessage(id, "Выбери тему");
//        startMessage.setReplyMarkup(new KeyBoardTable().getKeyBoardTable());
//        try {
//            execute(startMessage);
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }
    }
}
