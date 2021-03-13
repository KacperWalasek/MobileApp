package com.domowka.api.dao.user;

import com.domowka.api.model.User;
import com.domowka.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mySqlUserDao")
public class MySQLUserDao implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int insertUser( User user) {
        userRepository.save(user);
        return 0;
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public int deleteUser(UUID id) {
        userRepository.deleteById(id);
        return 0;
    }

    @Override
    public int updateUser(UUID id, User user) {
        Optional<User> oldUserOpt = userRepository.findById(id);
        if(oldUserOpt.isEmpty())
            return -1;
        User oldUser = oldUserOpt.get();
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        userRepository.save(oldUser);
        return 0;
    }

    @Override
    public User getUser(String username) {
        List<User> list = userRepository.findByUsername(username);
        return list.isEmpty()? null: list.get(0);
    }
}
