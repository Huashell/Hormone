package com.example.hormone.Controller;


import com.example.hormone.VO.UserVO;
import com.example.hormone.config.ApiResponse;
import com.example.hormone.entity.User;
import com.example.hormone.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
* @Description: 用户登录
* @Date: 2022/11/16
*/
@RestController
@RequestMapping("/")
public class LoginController {
    @Resource
    UserService userService;
    /**
     * 用户登录，查找id是否在数据库中，不在则添加
     * @param userVO
     * @return API response json
     */
    @PostMapping(value = "/login")
    ApiResponse login(@RequestBody UserVO userVO) {
        if(userService.loginOrRegister(userVO)){
            return ApiResponse.ok("登录成功");
        }
        else{
            return ApiResponse.error("密码错误");
        }
    }

    /**
    * @Description: 用户注册
    * @Param: [userVO]
    * @return: API response json
    * @Date: 2022/11/16
    */
    @PostMapping(value = "/register")
    ApiResponse register(@RequestBody UserVO userVO){
        if(null == userService.getMessageByUserId(userVO.getUserid())){
            if(userService.setUser(userVO)){
                return ApiResponse.ok("注册成功");
            }
            else{
                return ApiResponse.error("注册失败");
            }
        }else{
            return ApiResponse.error("用户名已存在");
        }
    }
}
