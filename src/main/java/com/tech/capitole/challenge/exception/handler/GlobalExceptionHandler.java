package com.tech.capitole.challenge.exception.handler;

import com.tech.capitole.challenge.exception.ResourceNotFoundException;
import com.tech.capitole.challenge.exception.ValidationException;
import com.tech.capitole.challenge.exception.model.ErrorResponse;
import com.tech.capitole.challenge.exception.model.ErrorValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.tech.capitole.challenge.util.Constants.STRING_ERROR_EXCEPTION;
import static com.tech.capitole.challenge.util.Constants.STRING_REQUEST_EXCEPTION;
import static com.tech.capitole.challenge.util.Utils.formatterOutput;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidation> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new ErrorValidation(
                STRING_REQUEST_EXCEPTION,
                errors,
                LocalDateTime.now().format(formatterOutput)
        ), HttpStatus.BAD_REQUEST);
    }

    // Manejo de excepción personalizada de tipo ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {

        return new ResponseEntity<>(new ErrorResponse(
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now().format(formatterOutput)
        ), HttpStatus.NOT_FOUND);
    }

    // Manejo de excepción personalizada de tipo ValidationException
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            ValidationException ex, WebRequest request) {

        return new ResponseEntity<>(new ErrorResponse(
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now().format(formatterOutput)
        ), HttpStatus.BAD_REQUEST);
    }

    // Manejo genérico de otras excepciones (Fallback para errores no controlados)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {

        return new ResponseEntity<>(new ErrorResponse(
                STRING_ERROR_EXCEPTION,
                request.getDescription(false),
                LocalDateTime.now().format(formatterOutput)
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
