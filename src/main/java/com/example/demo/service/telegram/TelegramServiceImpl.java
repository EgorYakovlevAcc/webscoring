package com.example.demo.service.telegram;

import com.example.demo.bot.Bot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.Objects;

@Service
public class TelegramServiceImpl implements TelegramService {
    private TelegramBotsApi telegramBotsApi;
    private Bot bot;


    private TelegramBotsApi getTelegramBotsApi() {
        if (Objects.nonNull(this.telegramBotsApi)) {
            return this.telegramBotsApi;
        } else {
            return new TelegramBotsApi();
        }
    }

    private void registrateBotForApi() {
        try {
            bot = new Bot();
            getTelegramBotsApi().registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initBot() {
        registrateBotForApi();
    }

    @Override
    public void sendMessageToGroup(String text) {
        System.out.println("EGORKA2");
        if (Objects.nonNull(bot)) {
            System.out.println("EGORKA3");
            bot.sendMessage(text);
        }
    }
}
