package net.mirapps.upbitbot.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UpbitbotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpbitbotBackendApplication.class, args);
    }

}
