package com.example.hormone.controller;

import com.example.hormone.VO.Result;
import com.example.hormone.config.RsaProperties;
import com.example.hormone.config.exception.BadRequestException;
import com.example.hormone.dto.AuthUserDto;
import com.example.hormone.entity.LoginParam;
import com.example.hormone.security.TokenProvider;
import com.example.hormone.service.UserService;
import com.example.hormone.utils.RedisUtils;
import com.example.hormone.utils.RsaUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


//    public Result<Map<String , String>> login(@RequestBody LoginParam param , HttpServletRequest request) {
//        String uid = param.getUid();
//        String password = param.getPassword();
////        if(isLoginFailOvertimes(uid)){
////            return R.fail(500, "该用户登录次数失败过多");
////        }
//        String captcha = param.getCaptcha();
//        if(captcha==null){
//            return Result.fail(500, "验证码无效");
//        }
//        String lowerCaseCaptcha = captcha.toLowerCase();
//        lowerCaseCaptcha + param.getCheckKey() +
//        //String token = userService.login(uid, password, request);
//        String token2 = userService.login(uid, password, request);
//        Map<String , String> map = new HashMap<>();
//        map.put("token" , token);
//        map.put("tokenHead" , tokenHead);
//
//        return Result.success(map);
//
//    }
//
//
//    @PostMapping("/logout")
//    public Result<String> logout (HttpServletRequest request, HttpServletResponse response) {
//        return userService.logout(request , response);
//    }

}
