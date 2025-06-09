package com.chatzone.dao;


import com.chatzone.entity.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;


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
    @Insert("INSERT INTO user (username, password, email, nickname, avatar, gender,age,signature,status,create_time) " +
            "VALUES (#{username}, #{password}, #{email}, #{nickname},#{avatar},#{gender},#{age},#{signature}, #{status},#{create_time})")
    public int insert(String username, String password, String email, String nickname, String avatar, String gender, int age, String signature, int status, LocalDateTime create_time);

    /**
     * 更新用户信息
     */

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    public User selectUserByUsernameAndPassword(String username, String password);

    @Update("UPDATE user SET nickname = #{nickname},age = #{age},gender = #{gender},signature = #{signature},avatar = #{avatar} WHERE id = #{id}")
    boolean update(int id, String nickname, int age, String gender, String signature, String avatar);

    @Update("UPDATE user SET nickname = #{nickname},age = #{age},gender = #{gender},signature = #{signature} WHERE id = #{id}")
    boolean updateWithOutAvatar(int id, String nickname, int age, String gender, String signature);

    @Select("SELECT avatar FROM user WHERE id = #{id}")
    String selectUserAvatar(int id);

    @Select("SELECT id FROM user where username = #{username}")
    Integer selectIdByUsername(String username);

    @Select("SELECT username FROM user WHERE id = #{id}")
    String selectUsernameById(long id);
    @Update("UPDATE user SET status = 1 WHERE id = #{id}")
    void UpdateStatusOn(Long id);
    @Update("UPDATE user SET status = 0 WHERE id = #{id}")
    void updateStatusOff(Long id);
}