package net.mirapps.upbitbot.backend.interfaces.notification.impl;

import lombok.RequiredArgsConstructor;

import net.mirapps.upbitbot.backend.interfaces.notification.NotificationService;
import net.mirapps.upbitbot.backend.interfaces.notification.feign.TelegramFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelegramService implements NotificationService {

    @Value("${interfaces.notification.telegram.bottokenkey}")
    private String telegramBotTokenKey;

    @Value("${interfaces.notification.telegram.bottokenvalue}")
    private String telegramBotTokenValue;

    @Value("${interfaces.notification.telegram.chatid}")
    private String telegramChatId;

    private final TelegramFeignClient telegramFeignClient;

    @Override
    public String send(String text) {
        if (text == null && text.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return telegramFeignClient.send(telegramBotTokenKey, telegramBotTokenValue, telegramChatId, text);
    }
}
