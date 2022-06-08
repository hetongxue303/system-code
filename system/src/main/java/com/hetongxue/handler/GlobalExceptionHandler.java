package com.hetongxue.handler;

import com.hetongxue.response.ResponseCode;
import com.hetongxue.response.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 全局异常处理
 * @ClassNmae: GlobalExceptionHandler
 * @Author: 何同学
 * @DateTime: 2022-06-08 16:40
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final HttpServletResponse response;

    /**
     * 未知异常
     */
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        response.setStatus(ResponseCode.INSUFFICIENT_STORAGE.getCode());
        return Result.Fail()
                .setMessage(ResponseCode.INTERNAL_SERVER_ERROR.getMessage())
                .setCode(ResponseCode.INTERNAL_SERVER_ERROR.getCode());
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result runtimeException(RuntimeException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        response.setStatus(ResponseCode.INSUFFICIENT_STORAGE.getCode());
        return Result.Fail()
                .setMessage(ResponseCode.INTERNAL_SERVER_ERROR.getMessage())
                .setCode(ResponseCode.INTERNAL_SERVER_ERROR.getCode());
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerException(NullPointerException e) {
        e.printStackTrace();
        log.error(ResponseCode.NULL_POINTER.getMessage());

        return Result.Fail()
                .setMessage(ResponseCode.NULL_POINTER.getMessage())
                .setCode(ResponseCode.NULL_POINTER.getCode());
    }

}