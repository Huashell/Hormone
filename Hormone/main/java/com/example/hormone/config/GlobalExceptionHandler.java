package com.example.hormone.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException exception) {

        log.error(exception.getMessage());

        if (exception.getMessage().contains("Duplicate entry")) {
            String[] split = exception.getMessage().split(" ");
            String msg = split[2] + "已存在...";
            return R.error(msg);
        }

        return R.error("未知错误...");

    }

    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException exception) {

        log.error(exception.getMessage());

        return R.error(exception.getMessage());

    }

}
