package com.domowka.api.api;

import com.domowka.api.dto.LoginDTO;
import com.domowka.api.dto.LoginResponseDTO;
import com.domowka.api.model.PartyMember;
import com.domowka.api.model.User;
import com.domowka.api.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
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
    @PostMapping(path = "/register")
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
    @GetMapping(value = "/login")
    public LoginResponseDTO login(@RequestBody LoginDTO loginDTO){
        LoginResponseDTO dto = service.login(loginDTO);
        if(dto == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong username or password");
        return dto;
    }
    @GetMapping(path="/refreshToken/{token}")
    public LoginResponseDTO refreshToken(@PathVariable("token") String token){
        return service.refreshToken(token);
    }
    @GetMapping(path = "/memberships/{id}")
    public List<PartyMember> getMemberships(@PathVariable("id") UUID userID){
        return service.getMemberships(userID);
    }


}
