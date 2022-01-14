package com.coderhouse.springbackendjpamysql.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    Logger logger = LogManager.getLogger(GlobalControllerExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String IdNotFound(IdNotFoundException ex) {
        logger.error(ex.getMessage());
        return ex.getMessage();
    }

}
