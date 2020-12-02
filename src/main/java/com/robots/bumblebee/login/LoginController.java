package com.robots.bumblebee.login;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "简书-演示",description = "用来演示Swagger的一些注解")

public class LoginController{
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private JWTService jwtService;

    @ApiOperation(value="登录", notes="登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "user", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "pwd", value = "密码", required = true, dataType = "String")
    })
    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestParam(value="user") String user, @RequestParam(value="pwd") String pwd){
        String token = jwtService.createToken(user);

        return ResponseEntity.ok(token);
    }

    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })

    @GetMapping("/updatePassword")
    public String updatePassword(@RequestParam(value="userId") Integer userId, @RequestParam(value="password") String password,
                                 @RequestParam(value="newPassword") String newPassword){
        if(userId <= 0 || userId > 2){
            return "未知的用户";
        }
        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
            return "密码不能为空";
        }
        if(password.equals(newPassword)){
            return "新旧密码不能相同";
        }
        return "密码修改成功!";
    }
}
