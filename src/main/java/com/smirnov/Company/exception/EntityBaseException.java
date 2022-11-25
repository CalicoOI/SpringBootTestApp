package com.smirnov.Company.exception;

import com.smirnov.Company.enums.UserErrors;
import lombok.Getter;

@Getter
public class EntityBaseException extends BaseException {
    private int id;
    private String name;
    private UserErrors userErrors;

    public EntityBaseException(UserErrors userErrors, Integer id) {
        this.id = id;
        this.userErrors = userErrors;
    }

    public EntityBaseException(UserErrors userErrors, String name) {
        this.name = name;
        this.userErrors = userErrors;
    }


    public EntityBaseException(UserErrors userErrors){
        this.userErrors = userErrors;
    }
}
