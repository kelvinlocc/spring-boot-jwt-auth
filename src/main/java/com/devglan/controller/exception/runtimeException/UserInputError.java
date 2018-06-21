package com.devglan.controller.exception.runtimeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ccloa on 21/6/2018.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserInputError extends RuntimeException {
    public UserInputError(String exceptionMessage) {
        super(exceptionMessage);
    }

}