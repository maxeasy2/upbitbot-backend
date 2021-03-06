package net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class DisclosureDataDto {
    private boolean more;
    private int offset;
    private List<DisclosureDataPostDto> posts;
}
