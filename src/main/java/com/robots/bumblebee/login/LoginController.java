package com.robots.bumblebee.login;

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
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
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

    @PostMapping("register")
    @ApiOperation(value = "注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "confirmPwd", value = "确认密码", required = true, dataType = "String")
    })
    @SkipToken(required = true)
    public ResponseEntity<String> register(@RequestParam(value = "account") String account,
                                           @RequestParam(value = "pwd") String pwd,
                                           @RequestParam(value = "confirmPwd") String confirmPwd) {
        if(ObjectUtils.isEmpty(account)){
            return ResponseEntity.ok("账号不能为空");
        }
        if(ObjectUtils.isEmpty(pwd) || ObjectUtils.isEmpty(confirmPwd)){
            return ResponseEntity.ok("密码不能空");
        }
        if(!pwd.equals(confirmPwd)){
            return ResponseEntity.ok("两次输入的密码不一致");
        }
        User user = new User();
        user.setAccount(account);
        userService.save(user);
        return ResponseEntity.ok("注册成功");
    }

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, dataType = "String",example = "test"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String",example = "1234")
    })
    @GetMapping("login")
    @SkipToken(required = true)
    public ResponseEntity<String> login(@RequestParam(value = "account") String account, @RequestParam(value = "pwd") String pwd) {
        User user = userService.getUserByAccount(account);
        if(user == null){
            return ResponseEntity.ok("用戶不存在！");
        }
        String token = jwtService.createToken(user.getId());
        return ResponseEntity.ok(token);
    }

}
