package net.mirapps.upbitbot.backend.interfaces.upbit.market.feign;

import net.mirapps.upbitbot.backend.interfaces.upbit.market.dto.CoinDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "MarketFeignClient", url = "${interfaces.api-upbit.url}")
public interface MarketFeignClient {

    @GetMapping("/v1/market/all")
    List<CoinDto> getMarketList(@RequestParam String isDetails);

}
