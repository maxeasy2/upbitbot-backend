package net.mirapps.upbitbot.backend;

import lombok.RequiredArgsConstructor;
import net.mirapps.upbitbot.backend.interfaces.upbit.market.service.MarketService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableFeignClients
@SpringBootApplication
public class UpbitbotBackendApplication implements ApplicationRunner {

    private final MarketService marketService;

    public static void main(String[] args) {
        SpringApplication.run(UpbitbotBackendApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        marketService.setMarketList();
    }
}
