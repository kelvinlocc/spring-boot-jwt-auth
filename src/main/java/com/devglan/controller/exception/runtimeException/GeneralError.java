package com.devglan.controller.exception.runtimeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ccloa on 21/6/2018.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneralError extends RuntimeException {
    public GeneralError(String exceptionMessage) {
        super(exceptionMessage);
    }

}