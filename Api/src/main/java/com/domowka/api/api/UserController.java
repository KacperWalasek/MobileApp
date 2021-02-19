package com.domowka.api.api;

import com.domowka.api.model.User;
import com.domowka.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/user")
@RestController
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService service){

        this.service = service;
    }
    @GetMapping
    public Iterable<User> getAllUsers(){

        return this.service.getAllUsers();
    }
    @PostMapping
    public void addUser(@RequestBody User user){

        this.service.addUser(user);
    }
    @PutMapping(path="{id}")
    public void updateUser(@PathVariable("id") UUID id, @RequestBody User user){
        service.updateUser(id,user);
    }
    @DeleteMapping(path="{id}")
    public void deleteUser(@PathVariable("id") UUID id){
        if(service.deleteUser(id)!=0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no user with such id in database");
    }
    @GetMapping(path = "{id}")
    public User getUser(@PathVariable("id") UUID id){
        Optional<User> user = service.getUser(id);
        if(user.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no user with such id in database");
        return user.get();
    }



}
