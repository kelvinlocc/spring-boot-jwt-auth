package com.devglan.controller.exception.runtimeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ccloa on 21/6/2018.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerInternalError extends RuntimeException {
    public ServerInternalError(String exceptionMessage) {
        super(exceptionMessage);
    }

}