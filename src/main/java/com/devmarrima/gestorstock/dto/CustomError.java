package com.devmarrima.gestorstock.dto;

import lombok.Getter;

import java.time.Instant;

@Getter
public class CustomError {
    private final Instant timeStamp;
    private final Integer status;
    private final String error;
    private final String path;

    public CustomError(Instant timeStamp, Integer status, String error, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

}
