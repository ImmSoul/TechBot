package com.project.TechBot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KeyBoardTable {

    public ReplyKeyboardMarkup getKeyBoardTable() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Справка"));
        row1.add(new KeyboardButton("О создателях"));
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Меню"));
        row2.add(new KeyboardButton("Не нажимай!"));

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        return replyKeyboardMarkup;

    }
}
