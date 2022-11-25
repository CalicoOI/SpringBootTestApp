package com.smirnov.Company.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrors {
    FAILED_TO_CREATE_EMPLOYEE("Failed to create employee", "UE1", HttpStatus.NOT_ACCEPTABLE),
    EMPLOYEE_NOT_FOUND("Employee with Id %d not found", "UE2", HttpStatus.NOT_FOUND),
    FAILED_TO_UPDATE_EMPLOYEE("Employee with Id %d not found", "UE3", HttpStatus.NOT_FOUND),
    FAILED_TO_DELETE_EMPLOYEE("Employee with Id %d not found, or delete was forbidden", "UE4", HttpStatus.NOT_FOUND),

    FAILED_TO_CREATE_PROJECT("Failed to create project", "UE1", HttpStatus.NOT_ACCEPTABLE),
    PROJECT_NOT_FOUND("Project with Id %d not found", "UE2", HttpStatus.NOT_FOUND),
    PROJECT_WITH_NAME_NOT_FOUND("Project with name %s not found", "UE3", HttpStatus.NOT_FOUND),
    FAILED_TO_UPDATE_PROJECT("Project with Id %d not found", "UE4", HttpStatus.NOT_FOUND),
    FAILED_TO_DELETE_PROJECT("Employee with Id %d not found, or delete was forbidden", "UE5", HttpStatus.NOT_FOUND);


    private final String message;
    private final String internalErrorCode;
    private final HttpStatus httpStatus;

    @Override
    public String toString() {
        return String.format("Message: %s\nInternal error code: %s", message, internalErrorCode);
    }
}
