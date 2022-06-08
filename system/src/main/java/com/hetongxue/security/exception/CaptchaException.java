package com.hetongxue.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Description: 验证码异常类
 * @ClassNmae: CaptchaException
 * @Author: 何同学
 * @DateTime: 2022-06-08 17:04
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CaptchaException(String msg) {
        super(msg);
    }

}