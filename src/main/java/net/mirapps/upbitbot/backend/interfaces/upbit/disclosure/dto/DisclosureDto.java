package net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DisclosureDto {
    private DisclosureDataDto data;
    private boolean success;
    private String time;

}
