package com.example.hormone.service.impl;

import com.example.hormone.VO.UserVO;
import com.example.hormone.dto.UserDto;
import com.example.hormone.entity.User;
import com.example.hormone.repository.UserRepository;
import com.example.hormone.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public Boolean setMessage(UserVO userVO) {
        try {
            User mes = new User();
            mes.setUserid(userVO.getUserid());
            mes.setPassword(userVO.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public Boolean setUser(UserVO userVO) {
        try {
            userRepository.setMessage(userVO.getUserid(), userVO.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User getMessageByUserId(String id) {
        return userRepository.findAllByuserid(id);
    }

    @Override
    public boolean loginOrRegister(UserVO user) {
        User messageByUserId = getMessageByUserId(user.getUserid());
        if(messageByUserId.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}

