package com.domowka.api.service;

import com.domowka.api.dao.user.UserDao;
import com.domowka.api.dto.LoginDTO;
import com.domowka.api.dto.LoginResponseDTO;
import com.domowka.api.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(@Qualifier("mySqlUserDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.insertUser(user);
    }

    public Iterable<User> getAllUsers(){ return userDao.getAllUsers(); }
    public Optional<User> getUser(UUID id){
        return userDao.getUser(id);
    }
    public int deleteUser(UUID id){
        return userDao.deleteUser(id);
    }

    public int updateUser(UUID id, User user){
        Optional<User> oldUser = getUser(id);
        if(oldUser.isEmpty())
            return -1;
        user.setPassword(oldUser.get().getPassword());
        return userDao.updateUser(id, user);
    }

    public LoginResponseDTO login(LoginDTO loginDTO) {
        User user = userDao.getUser(loginDTO.getUsername());
        if(user==null || !passwordEncoder.matches(loginDTO.getPassword(), user.getPassword()))
            return null;
        return user == null? null: new LoginResponseDTO(user.getId(),
                getJWTToken(user.getUsername(),60), // 10 minutes
                getJWTToken(user.getUsername(), 4*3600)); //4 hours
    }

    public LoginResponseDTO refreshToken(String token){
        Claims claims = Jwts.parser().setSigningKey("mySecretKey".getBytes()).parseClaimsJws(token).getBody();
        User user = userDao.getUser(claims.getSubject());
        return new LoginResponseDTO(user.getId(),
                getJWTToken(user.getUsername(),60),
                getJWTToken(user.getUsername(), 4*3600));
    }

    private String getJWTToken(String username, Integer seconds) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("domowkaJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + seconds * 1000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }
}
