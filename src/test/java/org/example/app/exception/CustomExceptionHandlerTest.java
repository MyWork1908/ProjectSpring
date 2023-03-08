package org.example.app.exception;

import jdk.jshell.spi.ExecutionControl;
import org.example.app.models.response.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class CustomExceptionHandlerTest {
    @Test
    void testHandlerNotImplementedException() {
        ExecutionControl.NotImplementedException ex = new ExecutionControl.NotImplementedException("NotImplementedException");
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_IMPLEMENTED, ex.getMessage());
        CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
        ErrorResponse result = customExceptionHandler.handlerNotImplementedException(ex);
        assertEquals(response.getStatus(), result.getStatus());
        assertEquals(response.getMsg(), result.getMsg());
    }

    @Test
    void testHandlerNotFoundException() {
        NotFoundException ex = new NotFoundException("NotFoundException");
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
        ErrorResponse result = customExceptionHandler.handlerNotFoundException(ex);
        assertEquals(response.getStatus(), result.getStatus());
        assertEquals(response.getMsg(), result.getMsg());
    }
}