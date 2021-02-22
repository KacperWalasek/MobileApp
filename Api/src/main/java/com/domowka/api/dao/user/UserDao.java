package com.domowka.api.dao.user;

import com.domowka.api.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    int insertUser( User user);
    Optional<User> getUser(UUID id);
    Iterable<User> getAllUsers();
    int deleteUser(UUID id);
    int updateUser(UUID id, User user);

    User getUser(String username);
}
