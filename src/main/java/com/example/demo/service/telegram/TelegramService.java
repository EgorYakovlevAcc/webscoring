package com.example.demo.service.telegram;

public interface TelegramService {
    void initBot();
    void sendMessageToGroup(String text);
}
