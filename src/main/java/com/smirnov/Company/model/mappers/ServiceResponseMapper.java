package com.smirnov.Company.model.mappers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServiceResponseMapper {
    public <T> ResponseEntity<?> getPositiveResponseEntity(String fieldName, T fieldValue, HttpStatus statusCode) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put(fieldName, fieldValue);

        return new ResponseEntity<>(body, statusCode);
    }
}
