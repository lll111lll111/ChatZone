package com.chatzone.dao;

import com.chatzone.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface UserDao {
    /**
     * 根据用户名查找用户
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);

    /**
     * 根据邮箱查找用户
     */
    @Select("SELECT * FROM user WHERE email = #{email}")
    User findByEmail(@Param("email") String email);

    /**
     * 根据ID查找用户
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") Long id);

    /**
     * 检查用户名是否存在
     */
    @Select("SELECT COUNT(*) FROM user WHERE username = #{username}")
    boolean existsByUsername(@Param("username") String username);

    /**
     * 检查邮箱是否存在
     */
    @Select("SELECT COUNT(*) FROM user WHERE email = #{email}")
    boolean existsByEmail(@Param("email") String email);

    /**
     * 插入新用户
     */
    @Insert("INSERT INTO user (username, password, email, nickname, avatar,signature,status, create_time) " +
            "VALUES (#{username}, #{password}, #{email}, #{nickname},#{avatar},#{signature}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    User insert(String username, String password, String email, String nickname, String avatar, String signature, int status);

    /**
     * 更新用户信息
     */

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    public User selectUserByUsernameAndPassword(String username,String password);
}