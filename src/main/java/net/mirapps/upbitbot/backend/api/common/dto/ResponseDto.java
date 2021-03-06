package net.mirapps.upbitbot.backend.api.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ResponseDto<T> {
    private T data;
    private String message;
    private LocalDateTime dateTime = LocalDateTime.now();
}
