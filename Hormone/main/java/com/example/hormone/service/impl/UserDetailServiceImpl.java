//package com.example.hormone.service.impl;
//
//import com.example.hormone.entity.User;
//import com.example.hormone.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Objects;
//
//@Component
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    @Resource
//    UserRepository userRepository;
//    @Override
//    public User loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findUserByUsername(username);
//        if (Objects.isNull(user)) {
//            throw new UsernameNotFoundException("用户不存在");
//        }
//        return user;
//    }
//}
