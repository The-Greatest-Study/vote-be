package tgs.vote.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tgs.vote.application.dto.ResponseDTO;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    ResponseEntity<ResponseDTO<?>> handleException(Exception exception) {
        log.error(exception.getLocalizedMessage());
        return new ResponseEntity<>(
                ResponseDTO.ofError(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
