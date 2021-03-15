package net.mirapps.upbitbot.backend.interfaces.upbit.market.service;

import net.mirapps.upbitbot.backend.interfaces.upbit.market.dto.CoinDto;

import java.util.List;

public interface MarketService {
    CoinDto getMarketOne(String market);

    List<CoinDto> getMarketList();

    boolean setMarketList();
}
