package net.mirapps.upbitbot.backend.interfaces.upbit.market.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoinDto {
    private String market;
    @JsonProperty("korean_name")
    private String koreanName;
    @JsonProperty("english_name")
    private String englishName;
    @JsonProperty("market_warning")
    private String marketWarning;
}
