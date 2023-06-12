package com.example.hormone.security.handler;

import com.alibaba.fastjson.JSON;

import com.example.hormone.config.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UnAuthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request , HttpServletResponse response , AuthenticationException authException) throws IOException, ServletException {
        R<String> result = new R<>();
        result.setCode(0);
        result.setMsg("用户未登录");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}