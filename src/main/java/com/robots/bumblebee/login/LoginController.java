package com.robots.bumblebee.login;

import com.robots.bumblebee.entity.db.ArticleEntity;
import com.robots.bumblebee.entity.db.User;
import com.robots.bumblebee.security.SkipToken;
import com.robots.bumblebee.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "注冊-登录")
@RestController("/user/")
public class LoginController{
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserService userService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("register")
    @ApiOperation(value="注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "confirmPwd", value = "确认密码", required = true, dataType = "String")
    })
    public ResponseEntity<String> register(@RequestParam(value="account") String account,
                                           @RequestParam(value="pwd") String pwd,
                                           @RequestParam(value = "confirmPwd") String confirmPwd){
        return ResponseEntity.ok("注册成功");
    }

    @ApiOperation(value="登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "account", value = "account", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String")
    })
    @GetMapping("/login")
    @SkipToken(required = true)
    public ResponseEntity<Object> login(@RequestParam(value="account") String account, @RequestParam(value="pwd") String pwd){
        String token = jwtService.createToken(account);
        User userByName = userService.getUserByAccount(account);
        ArticleEntity e = new ArticleEntity();
//        e.setName("namee");
        e.setId(22111l);
        e.setContext("bbbb");
        e.setTitle("titttle标题");
        mongoTemplate.save(e);
        return ResponseEntity.ok(token);
    }

}
