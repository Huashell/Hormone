package com.example.hormone.Controller;

import com.example.hormone.config.R;
import com.example.hormone.entity.LoginParam;
import com.example.hormone.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @PostMapping("/login")
    public R<Map<String , String>> login(@RequestBody LoginParam param , HttpServletRequest request) {

        String token = userService.login(param.getUid() , param.getPassword() , request);

        Map<String , String> map = new HashMap<>();
        map.put("token" , token);
        map.put("tokenHead" , tokenHead);

        return R.success(map);

    }


    @PostMapping("/logout")
    public R<String> logout (HttpServletRequest request, HttpServletResponse response) {
        return userService.logout(request , response);
    }

}
