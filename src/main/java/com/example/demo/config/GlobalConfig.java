package com.example.demo.config;

import com.example.demo.service.telegram.TelegramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;

@Component
public class GlobalConfig implements CommandLineRunner {
    @Autowired
    private TelegramService telegramService;

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalConfig.class);
    @Override
    public void run(String... args) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("run [START]");
            LOGGER.debug("ApiContextInitializer: init");
        }
        ApiContextInitializer.init();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("telegramService: initBot");
        }
        telegramService.initBot();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("run [FINISH]");
        }
    }
}
