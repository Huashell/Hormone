package com.example.hormone.repository;

import com.example.hormone.VO.UserVO;
import com.example.hormone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    User findAllByuserid(String Id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `user` VALUES (?1, ?2);",nativeQuery = true)
    int setMessage(String userid, String password);

}