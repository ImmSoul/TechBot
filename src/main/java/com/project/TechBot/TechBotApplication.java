package com.project.TechBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

@SpringBootApplication
public class TechBotApplication {

	public static void main(String[] args) throws TelegramApiException, IOException, ClassNotFoundException {
		SpringApplication.run(TechBotApplication.class, args);
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
		Bot bot = new Bot();
		bot.getUsers();
		telegramBotsApi.registerBot(bot);

	}

}
