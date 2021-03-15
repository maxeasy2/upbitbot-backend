package net.mirapps.upbitbot.backend.interfaces.upbit.market.mapper;

import net.mirapps.upbitbot.backend.interfaces.upbit.market.dto.CoinDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MarketMapper {
    int deleteMarketList();

    int insertMarket(CoinDto coinDto);

    List<CoinDto> selectMarketList();

    CoinDto selectMarket(String market);
}
