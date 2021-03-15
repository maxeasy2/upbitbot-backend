package net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DisclosureDataPostDto {
    private String assets;
    private int id;
    @JsonProperty(value = "start_date")
    private String startDate;
    private String text;
    private String url;
    private List<String> marketNameList;
}
