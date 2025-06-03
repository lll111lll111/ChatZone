package com.dyhczh.chat_zone.service;

import com.dyhczh.chat_zone.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean signup(){

    }
}
