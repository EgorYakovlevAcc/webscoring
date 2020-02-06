package com.example.demo.controller;

import com.example.demo.service.telegram.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TelegramController {
    @Autowired
    private TelegramService telegramService;

    @GetMapping(value = "bot/send")
    @ResponseBody
    public String initBotForGroup(@RequestParam("text") String text) {
        telegramService.sendMessageToGroup(text);
        return "text is sent to chat";
    }
}
