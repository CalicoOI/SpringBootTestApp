package com.smirnov.Company.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServerErrors {

    FAILED_TO_ACCESS_DB("Timeout exception. Db is unavailable", "SU1");

    private final String message;
    private final String internalErrorCode;

    @Override
    public String toString() {
        return String.format("Message: %s\nInternal error code: %s", message, internalErrorCode);
    }
}
