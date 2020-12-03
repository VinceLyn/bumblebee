package com.robots.bumblebee.login;

import com.robots.bumblebee.entity.db.User;
import com.robots.bumblebee.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "简书-演示",description = "用来演示Swagger的一些注解")

public class LoginController{
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserService userService;

    @ApiOperation(value="登录", notes="登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestParam(value="account") String account, @RequestParam(value="pwd") String pwd){
        String token = jwtService.createToken(account);
        User userByName = userService.getUserByAccount(account);

        return ResponseEntity.ok(token);
    }

}
