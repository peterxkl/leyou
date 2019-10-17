package com.leyou.advice;

import com.leyou.enums.ExceptionEnums;
import com.leyou.exception.LyException;
import com.leyou.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(LyException.class)
    public ResponseEntity<ExceptionResult> handleException(LyException e) {
        ExceptionEnums enums = e.getExceptionEnums();
        return ResponseEntity.status(enums.getCode()).body(new ExceptionResult(enums));
    }
}
