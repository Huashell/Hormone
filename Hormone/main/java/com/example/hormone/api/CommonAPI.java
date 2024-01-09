package com.example.hormone.api;

import com.example.hormone.entity.User;

import java.util.Set;

public interface CommonAPI {

    /**
    * @Description: 查询用户角色信息
    * @Param: username
    * @return
    **/
    Set<String> queryUserRoles(String userid);

    /**
    * @Description: 查询用户权限信息
    * @Param:
    * @return
    **/
    Set<String> queryUserAuths(String userid);

    /**
    * @Description: 根据用户查询用户信息
    * @Param:
    * @return
    **/
    public User getUserByName(String username);


}
