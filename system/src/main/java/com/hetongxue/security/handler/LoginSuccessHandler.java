package com.hetongxue.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hetongxue.lang.Const;
import com.hetongxue.response.Result;
import com.hetongxue.utils.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 认证成功处理器
 * @ClassNmae: LoginSuccessHandler
 * @Author: 何同学
 * @DateTime: 2022-06-08 17:08
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        // 生成token
        response.setHeader(Const.AUTHORIZATION_KEY, jwtUtils.generateToken(authentication.getName()));
        response.getWriter().println(new ObjectMapper().writeValueAsString(Result.Success().setMessage("登陆成功")));
    }

}