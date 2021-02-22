package com.domowka.api.dao.user;

import com.domowka.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import  java.util.List;
import java.util.UUID;

@Repository("mockUserDao")
public class MockUserDao implements UserDao {
    @Override
    public int insertUser(User user) {
        users.add(new User( user));
        return 0;
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return users.stream().filter(user -> user.getId()==id).findFirst();
    }

    @Override
    public Iterable<User> getAllUsers() {
        return users;
    }

    @Override
    public int deleteUser(UUID id) {
        return 0;
    }

    @Override
    public int updateUser(UUID id, User user) {
        return 0;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    List<User> users = new ArrayList<>();
}
