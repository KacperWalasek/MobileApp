package com.domowka.api.repository;

import com.domowka.api.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    List<User> findByUsername(String username);
}