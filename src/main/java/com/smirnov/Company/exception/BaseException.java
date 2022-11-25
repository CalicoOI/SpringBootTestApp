package com.smirnov.Company.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BaseException extends RuntimeException{
    public BaseException(Object msg) {
        super(msg.toString());
    }
}
