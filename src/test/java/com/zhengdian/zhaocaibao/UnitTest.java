package com.zhengdian.zhaocaibao;

import com.zhengdian.zhaocaibao.entity.User;
import com.zhengdian.zhaocaibao.service.UserService;
import com.zhengdian.zhaocaibao.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {

    @Before
    public void before() {
        System.out.println("前期准备");

    }

    @Test
    public void login() {

        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUserPhone("18339956503");
        user.setPassword("123");
        System.out.println(userService.validateUser(user));
    }
}
