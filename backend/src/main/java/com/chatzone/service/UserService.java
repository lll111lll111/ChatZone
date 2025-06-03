package com.chatzone.service;

import com.chatzone.dao.UserDao;
import com.chatzone.entity.User;
import com.chatzone.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User login(String username,String password){
        //输入数据含有非法字符
        if(!(username.matches("^[a-zA-Z0-9_]+$") && password.matches("^[a-zA-Z0-9_]+$"))) throw new InvalidCharException();
        User user = userDao.selectUserByUsernameAndPassword(username,password);
        //用户名或密码错误
        if (user == null) throw new WrongLoginInfoException();
        return user;
    }

    public User signup(String username,String password,String confirmPassword,String email) {
        //输入数据含有非法字符
        if(!(username.matches("^[a-zA-Z0-9_]+$") && password.matches("^[a-zA-Z0-9_]+$") && confirmPassword.matches("^[a-zA-Z0-9_]+$"))) throw new InvalidCharException();
        //两次输入密码不一致
        if(!password.equals(confirmPassword)) throw new FailedToSignupException();
        //用户名已存在
        if(userDao.existsByUsername(username)) throw new UsernameAlreadyExistsException();
        //手机号已经存在
        if(userDao.existsByEmail(email)) throw new EmailAlreadyExistsException();
        //插入数据
        String nickname = STR."user_\{UUID.randomUUID().toString()}";
        String defaultAvatar = "/images/defaultAvatar.png";
        return userDao.insert(username,password,email,nickname, defaultAvatar,"这位用户没什么要说的...",1);
    }
}
