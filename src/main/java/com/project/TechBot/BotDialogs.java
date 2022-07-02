package com.project.TechBot;

public enum BotDialogs {
    START_DIALOG("Привет коллега! Что тебя привело в нашу обитель знаний? Я вижу тебя в первые в нашей обители..."),
    START_NAME("Как тебя зовут? Напиши своё ФИО."),
    START_FILIAL("С какого края ты прибыл? Укажи свой филиал.");



    private final String dialog;

    BotDialogs(String dialog) {
        this.dialog = dialog;
    }

    public String getDialog() {
        return dialog;
    }

}
