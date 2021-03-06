package net.mirapps.upbitbot.backend.interfaces.notification.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="TelegramFeignClient", url = "${interfaces.notification.telegram.url}")
public interface TelegramFeignClient {

    @GetMapping("/{botTokenKey}:{botTokenValue}/sendMessage?chat_id={chatId}&text={text}")
    String send(@PathVariable String botTokenKey,
                @PathVariable String botTokenValue,
                @PathVariable String chatId,
                @PathVariable String text);
}
