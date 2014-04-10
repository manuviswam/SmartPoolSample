package com.tw.service;

import com.tw.db.UserDAO;
import com.tw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional
    public List<User> getUserByName(String name){
        return userDAO.getUserByName(name);
    }
}
