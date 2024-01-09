package com.example.hormone.repository;

import com.example.hormone.VO.UserVO;
import com.example.hormone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

    User findByEmail(String email);

    User findByPhone(String phone);

    @Modifying
    @Query(value = "update user set password = ?2 , pwd_reset_time = ?3 where username = ?1", nativeQuery = true)
    void updatePass(String username, String pass, Date lastPasswordResetTime);

    @Modifying
    @Query(value = "update user set email = ?2 where username = ?1", nativeQuery = true)
    void updateEmail(String username, String email);

    @Query(value = "SELECT * FROM user u, users_roles r WHERE" +
            " u.user_id = r.user_id AND r.role_id = ?1", nativeQuery = true)
    List<User> findByRoleId(Integer roleId);

    @Query(value = "SELECT * FROM user u, users_roles ur, roles_menus rm WHERE\n" +
            "u.user_id = ur.user_id AND ur.role_id = rm.role_id AND rm.menu_id = ?1 group by u.user_id", nativeQuery = true)
    List<User> findByMenuId(Integer id);

    void deleteAllByUserIdIn(Set<Integer> ids);

    @Query(value = "SELECT count(1) FROM user u, users_jobs j WHERE u.user_id = j.user_id AND j.job_id IN ?1", nativeQuery = true)
    int countByJobs(Set<Integer> userIds);

    @Modifying
    @Query(value = "update user set password = ?2 where user_id in ?1", nativeQuery = true)
    void resetPwd(Set<Integer> ids, String pwd);
//    /**
//     * 根据用户名查询
//     * @param username 用户名
//     * @return /
//     */
//    User findByUsername(String username);
//
//    /**
//     * 根据邮箱查询
//     * @param email 邮箱
//     * @return /
//     */
//    User findByEmail(String email);
//
//    /**
//     * 根据手机号查询
//     * @param phone 手机号
//     * @return /
//     */
//    User findByPhone(String phone);
//
//    /**
//     * 修改密码
//     * @param username 用户名
//     * @param pass 密码
//     * @param lastPasswordResetTime /
//     */
//    @Modifying
//    @Query(value = "update sys_user set password = ?2 , pwd_reset_time = ?3 where username = ?1",nativeQuery = true)
//    void updatePass(String username, String pass, Date lastPasswordResetTime);
//
//    /**
//     * 修改邮箱
//     * @param username 用户名
//     * @param email 邮箱
//     */
//    @Modifying
//    @Query(value = "update sys_user set email = ?2 where username = ?1",nativeQuery = true)
//    void updateEmail(String username, String email);
//
//    /**
//     * 根据角色查询用户
//     * @param roleId /
//     * @return /
//     */
//    @Query(value = "SELECT u.* FROM sys_user u, sys_users_roles r WHERE" +
//            " u.user_id = r.user_id AND r.role_id = ?1", nativeQuery = true)
//    List<User> findByRoleId(Long roleId);
//
//
//
//    /**
//     * 根据菜单查询
//     * @param id 菜单ID
//     * @return /
//     */
//    @Query(value = "SELECT u.* FROM sys_user u, sys_users_roles ur, sys_roles_menus rm WHERE\n" +
//            "u.user_id = ur.user_id AND ur.role_id = rm.role_id AND rm.menu_id = ?1 group by u.user_id", nativeQuery = true)
//    List<User> findByMenuId(Long id);
//
//    /**
//     * 根据Id删除
//     * @param ids /
//     */
//    void deleteAllByuserIdIn(Set<Long> ids);
//
//    /**
//     * 根据岗位查询
//     * @param ids /
//     * @return /
//     */
//    @Query(value = "SELECT count(1) FROM sys_user u, sys_users_jobs j WHERE u.user_id = j.user_id AND j.job_id IN ?1", nativeQuery = true)
//    int countByJobs(Set<Long> userids);
//
//
//
//    /**
//     * 根据角色查询
//     * @param ids /
//     * @return /
//     */
////    @Query(value = "SELECT count(1) FROM sys_user u, sys_users_roles r WHERE " +
////            "u.user_id = r.user_id AND r.role_id in ?1", nativeQuery = true)
////    int countByRoles(Set<Long> ids);
//
//    /**
//     * 重置密码
//     * @param ids 、
//     * @param pwd 、
//     */
//    @Modifying
//    @Query(value = "update sys_user set password = ?2 where user_id in ?1",nativeQuery = true)
//    void resetPwd(Set<Long> ids, String pwd);
}