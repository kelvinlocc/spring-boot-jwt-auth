package com.devglan.controller.exception;

import com.devglan.controller.exception.runtimeException.ServerInternalError;
import com.devglan.controller.exception.runtimeException.GeneralError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * Created by ccloa on 21/6/2018.
 */
@ControllerAdvice
@RestController
public class CustomizedHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServerInternalError.class, GeneralError.class})
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ServerInternalError serverInternalError, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), serverInternalError.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.ACCEPTED);
    }
}

