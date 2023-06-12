package com.example.hormone.service;

import com.example.hormone.VO.UserVO;
import com.example.hormone.config.R;
import com.example.hormone.dto.UserDto;
import com.example.hormone.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    Boolean setMessage(UserVO userVO);

    List<UserDto> getAll();

    Boolean setUser(UserVO userVO);

    User getMessageByUserId(String id);

    boolean loginOrRegister(UserVO user);

    public String login(String username , String password, HttpServletRequest request);

    public R<String> logout(HttpServletRequest request, HttpServletResponse response);
}

