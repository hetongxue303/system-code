package com.hetongxue.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hetongxue.response.ResponseCode;
import com.hetongxue.response.Result;
import com.hetongxue.security.exception.CaptchaException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 认证失败处理器
 * @ClassNmae: LoginFailureHandler
 * @Author: 何同学
 * @DateTime: 2022-06-08 17:09
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Result result = Result.Fail().setMessage("登陆失败，未知异常！");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        if (exception instanceof AccountExpiredException) result.setMessage("账户已过期");
        if (exception instanceof BadCredentialsException) result.setMessage("用户名或密码错误");
        if (exception instanceof CredentialsExpiredException) result.setMessage("密码已过期");
        if (exception instanceof DisabledException) result.setMessage("账户被禁用");
        if (exception instanceof LockedException) result.setMessage("账户已被锁");
        if (exception instanceof InternalAuthenticationServiceException) result.setMessage("账户不存在");
        if (exception instanceof AuthenticationServiceException) result.setMessage(exception.getMessage());
        if (exception instanceof UsernameNotFoundException) result.setMessage(exception.getMessage());
        if (exception instanceof CaptchaException)
            result.setMessage(exception.getMessage())
                    .setCode(ResponseCode.VALIDATION_ERROR.getCode());
        response.getWriter().println(new ObjectMapper().writeValueAsString(result));
    }

}