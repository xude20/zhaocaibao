package com.zhengdian.zhaocaibao.controller;

import com.zhengdian.zhaocaibao.entity.User;
import com.zhengdian.zhaocaibao.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api("用户控制层")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    public List<User> test() {
        List<User> list = userService.selectAllUser();
        return list;
    }

    @GetMapping("test1")
    public int test1(int id) {
        int res = userService.selectUserById(id);
        return res;
    }

    @GetMapping("/login")
    @ApiOperation("登录接口，需要传参user的userphone和password")
    public boolean login(User user){
        boolean result = userService.validateUser(user);
        return result;
    }

    @GetMapping("/isAlreadyUse")
    @ApiOperation("前端检测手机号是否已经注册")
    public boolean isAlreadyUse(String userPhone) {
        boolean result = userService.isAlreadyUse(userPhone);
        return result;
    }

    @PostMapping("/register")
    @ApiOperation("这里是注册的方法")
    public boolean register(User user) {
        boolean result = userService.register(user);
        return result;
    }
}
