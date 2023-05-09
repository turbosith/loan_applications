package com.example.loan_applications.exception;

import com.example.loan_applications.model.response.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    /**
     * Метод, который перехватывает ошибку
     * @param exception - ошибка
     * @return - данные обошибке
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseException<DataException> handle(CustomException exception) {
        DataException dataException =
                new DataException(exception.getCode(), exception.getMessage());
        log.error(exception.getMessage(), exception.getCode(), exception);
        return new ResponseException<>(dataException);
    }
}
