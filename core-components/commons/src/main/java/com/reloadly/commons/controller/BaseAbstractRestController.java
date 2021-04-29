package com.reloadly.commons.controller;

import com.reloadly.commons.exceptions.ReloadlyException;
import com.reloadly.commons.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseAbstractRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseAbstractRestController.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ReloadlyException.class)
    public ErrorResponse handleReloadlyException(ReloadlyException e) {
        String message = "An error occurred";
        String errorDetail = extractMessage(e);
        LOGGER.error("Error occurred: description={}, detail={}", message, errorDetail);
        return new ErrorResponse("An error was encountered.", message, errorDetail);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericException(Exception e) {
        String message = "An error occurred";
        String errorDetail = extractMessage(e);
        LOGGER.error("Error occurred: description={}, detail={}", message, errorDetail);
        return new ErrorResponse("An error was encountered.", message, errorDetail);
    }

    private String extractMessage(Exception e) {
        String message = "";
        if (null != e.getMessage()) {
            message = e.getMessage();
        } else {
            // does it have a cause?
            if (null != e.getCause()) {
                if (null != e.getCause().getMessage()) {
                    message = e.getCause().getMessage();
                }
            }
        }
        return message;
    }
}
