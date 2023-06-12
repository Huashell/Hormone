package com.example.hormone.service.impl;

import com.example.hormone.VO.UserVO;
import com.example.hormone.config.R;
import com.example.hormone.dto.UserDto;
import com.example.hormone.entity.User;
import com.example.hormone.repository.UserRepository;
import com.example.hormone.service.UserService;
import com.example.hormone.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(String username , String password, HttpServletRequest request) {
        String token = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username , password);

            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            User user = (User) authenticate.getPrincipal();

            Claims claims = Jwts.claims();
            claims.put("id" , user.getUserid());
            claims.put("username" , user.getUsername());


            token = jwtTokenUtil.createToken(claims);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}" ,  e.getMessage());
        }
        return token;
    }
    @Override
    public R<String> logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return R.success("退出成功！");
    }

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

//            claims.put("personid" , user.getPersonid());
//            claims.put("role" , user.getRoles());