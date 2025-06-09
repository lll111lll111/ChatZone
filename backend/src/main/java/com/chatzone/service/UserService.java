package com.chatzone.service;

import com.chatzone.dao.UserDao;
import com.chatzone.entity.User;
import com.chatzone.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ImageStorageService imageStorageService;

    public User login(String username, String password) {
        //输入数据含有非法字符
        if (!(username.matches("^[a-zA-Z0-9_]+$") && password.matches("^[a-zA-Z0-9_]+$")))
            throw new InvalidCharException();
        User user = userDao.selectUserByUsernameAndPassword(username, password);
        //用户名或密码错误
        if (user == null) throw new WrongLoginInfoException();
        return user;
    }

    public int signup(String username, String password, String confirmPassword, String email) {
        //输入数据含有非法字符
        if (!(username.matches("^[a-zA-Z0-9_]+$") && password.matches("^[a-zA-Z0-9_]+$") && confirmPassword.matches("^[a-zA-Z0-9_]+$")))
            throw new InvalidCharException();
        //两次输入密码不一致
        if (!password.equals(confirmPassword)) throw new FailedToSignupException();
        //用户名已存在
        if (userDao.existsByUsername(username)) throw new UsernameAlreadyExistsException();
        //手机号已经存在
        if (userDao.existsByEmail(email)) throw new EmailAlreadyExistsException();
        //插入数据
        String nickname = STR."user_\{UUID.randomUUID().toString()}";
        nickname = nickname.substring(0, 16);
        String defaultAvatar = "/images/defaultAvatar.png";
        return userDao.insert(username, password, email, nickname, defaultAvatar, "男", 0, "这位用户没什么要说的...", 1, LocalDateTime.now());
    }

    public User getUserInfo(int id) {
        User user = userDao.findById((long) id);
        //用户不存在
        if (user == null) throw new UserNotFoundException();
        return user;
    }

    public User getUserInfoByUsername(String username) {
        User user = userDao.findByUsername(username);
        //用户不存在
        if (user == null) throw new UserNotFoundException();
        return user;
    }

    public void updateUserInfo(int id, String nickname, int age, String gender, String signature, MultipartFile avatar) throws IOException {
        //生成uuid,存储图片到本地
        // 1. 存储图片
        String imageUrl = imageStorageService.storeImage(avatar);
        //获取之前数据库存储的头像url
        String before = userDao.selectUserAvatar(id);
        // 2. 更新用户头像URL和其他数据到数据库
        boolean isUpdate = userDao.update(id, nickname, age, gender, signature, imageUrl);
        // 3.如果修改成功则删除原来的头像
        if (isUpdate && !before.equals("/images/defaultAvatar.png")) {
            String projectRoot = System.getProperty("user.dir");
            String deletePath = STR."\{projectRoot}/uploads/\{before}";
            Files.delete(Paths.get(deletePath));
        }
    }

    public void updateUserInfo(int id, String nickname, int age, String gender, String signature) throws IOException {
        boolean isUpdate = userDao.updateWithOutAvatar(id, nickname, age, gender, signature);
    }

    public Integer getIdByUserName(String username){
        return userDao.selectIdByUsername(username);
    }

    public void statusOn(Long loginId) {
        userDao.UpdateStatusOn(loginId);
    }

    public void statusOff(Long loginId) {
        userDao.updateStatusOff(loginId);
    }
}
