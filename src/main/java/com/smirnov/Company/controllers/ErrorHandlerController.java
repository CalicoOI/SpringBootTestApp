package com.smirnov.Company.controllers;

import com.smirnov.Company.enums.ServerErrors;
import com.smirnov.Company.enums.UserErrors;
import com.smirnov.Company.exception.BaseException;
import com.smirnov.Company.exception.EntityBaseException;
import com.smirnov.Company.model.dto.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.sql.SQLNonTransientConnectionException;


@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleUsersException(BaseException ex) {
        return new ResponseEntity<>(new ResponseBody(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLNonTransientConnectionException.class)
    public ResponseEntity<?> handleDataBaseException(SQLNonTransientConnectionException ex) {
        ServerErrors serverError = ServerErrors.FAILED_TO_ACCESS_DB;
        return new ResponseEntity<>(new ResponseBody(serverError.getMessage(), serverError.getInternalErrorCode()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityBaseException.class)
    public ResponseEntity<?> handleEntityBaseException(EntityBaseException ex) {
        UserErrors userError = ex.getUserErrors();
        return new ResponseEntity<>(new ResponseBody(String.format(userError.getMessage(), userError.toString().length() > 0 ? ex.getName() : ex.getId()), userError.getInternalErrorCode()), userError.getHttpStatus());
    }
}
