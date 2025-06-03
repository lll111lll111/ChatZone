package com.dyhczh.chat_zone.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Insert("INSERT INTO user (account, password, username, email, phone) VALUES (#{account},#{password},#{username},#{email},#{phone})")
    public boolean insertUser(String account,String password,String username,String email,String phone);
}
