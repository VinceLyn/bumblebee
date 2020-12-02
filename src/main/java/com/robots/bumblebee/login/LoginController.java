package com.robots.bumblebee.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController{
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private JWTService jwtService;

    @RequestMapping("/login")
    public ResponseEntity<Object> login(String user, String pwd){
        String token = jwtService.createToken(user);

        return ResponseEntity.ok(token);
    }
}
