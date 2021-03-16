package net.mirapps.upbitbot.backend.api.market;

import lombok.RequiredArgsConstructor;
import net.mirapps.upbitbot.backend.api.common.dto.ResponseDto;
import net.mirapps.upbitbot.backend.interfaces.upbit.market.service.MarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MarketController {

    private final MarketService marketService;

    @PostMapping("/api/v1/markets")
    public ResponseEntity refreshMarketInfo() {
        marketService.setMarketList();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("complete");
        return ResponseEntity.ok().body(responseDto);
    }
}
