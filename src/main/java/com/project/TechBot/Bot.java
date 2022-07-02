package com.project.TechBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Bot extends TelegramLongPollingBot {
    private String name = "TechnicsSS_bot";
    private String botToken = "5402567174:AAHcNymnlIrUUJfNXOQjz_8MTaXVEf71BmM";

    private Set<User> users = new HashSet<>();

    public void writeUsersList() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/resources/UsersList"))) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
            System.out.println("Запись успешна завершена");

        }
    }

    public void getUsers() {
        try (FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/UsersList"))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (objectInputStream.available() > 0) {
                users.add((User) objectInputStream.readObject());
            }
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


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

        User user = new User(id);
        if (!users.contains(user)) {


            users.add(user);
            SendMessage autoryMessage = new SendMessage(id, BotDialogs.START_DIALOG.getDialog());


            try {
                execute(autoryMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

            SendMessage messageName = new SendMessage(id, BotDialogs.START_NAME.getDialog());

            try {
                execute(messageName);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        } else if (!user.hasName) {

            user.setName(update.getMessage().toString());

            SendMessage messageName = new SendMessage(id, BotDialogs.START_FILIAL.getDialog());
            try {
                execute(messageName);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Добавлено имя");
        } else if (!user.hasFilial) {
            user.setFilial(update.getMessage().toString());

            try {
                writeUsersList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                writeUsersList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Добавлен филал");
        }
        else {
            SendMessage message = new SendMessage(id, "Готовченко");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
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
