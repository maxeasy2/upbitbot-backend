package net.mirapps.upbitbot.backend.interfaces.upbit.market.service;

import lombok.RequiredArgsConstructor;
import net.mirapps.upbitbot.backend.interfaces.upbit.market.dto.CoinDto;
import net.mirapps.upbitbot.backend.interfaces.upbit.market.feign.MarketFeignClient;
import net.mirapps.upbitbot.backend.interfaces.upbit.market.mapper.MarketMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MarketServiceImpl implements MarketService {

    private final MarketFeignClient marketFeignClient;

    private final MarketMapper marketMapper;

    @Override
    public CoinDto getMarketOne(String market) {
        return marketMapper.selectMarket(market);
    }

    @Override
    public List<CoinDto> getMarketList() {
        return marketMapper.selectMarketList();
    }

    @Override
    public boolean setMarketList() {
        List<CoinDto> coinDtoList = marketFeignClient.getMarketList("false");
        if (coinDtoList != null && coinDtoList.size() > 0) {
            marketMapper.deleteMarketList();
            for (CoinDto coinDto : coinDtoList) {
                marketMapper.insertMarket(coinDto);
            }
        }
        return true;
    }
}
