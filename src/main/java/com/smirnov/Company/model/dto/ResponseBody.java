package com.smirnov.Company.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import java.time.ZonedDateTime;

@Getter
public class ResponseBody {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final ZonedDateTime timeStamp;
    private String resultMsg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String internalErrorCode;

    public ResponseBody(String resultMsg, String internalErrorCode) {
        this.timeStamp = ZonedDateTime.now();
        this.resultMsg = resultMsg;
        this.internalErrorCode = internalErrorCode;
    }
    public ResponseBody(String resultMsg) {
        this.timeStamp = ZonedDateTime.now();
        this.resultMsg = resultMsg;
    }
}
