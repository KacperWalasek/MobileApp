package com.domowka.api.service;

import com.domowka.api.dao.user.UserDao;
import com.domowka.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;
    @Autowired
    public UserService(@Qualifier("mySqlUserDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user){
        return userDao.insertUser(user);
    }

    public Iterable<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    public int deleteUser(UUID id){
        return userDao.deleteUser(id);
    }
    public int updateUser(UUID id, User user){
        return userDao.updateUser(id, user);
    }
    public Optional<User> getUser(UUID id){
        return userDao.getUser(id);
    }

}
