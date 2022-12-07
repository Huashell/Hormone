package com.example.hormone.service;

import com.example.hormone.VO.UserVO;
import com.example.hormone.dto.UserDto;
import com.example.hormone.entity.User;

import java.util.List;

public interface UserService {

    Boolean setMessage(UserVO userVO);

    List<UserDto> getAll();

    Boolean setUser(UserVO userVO);

    User getMessageByUserId(String id);

    boolean loginOrRegister(UserVO user);
}

