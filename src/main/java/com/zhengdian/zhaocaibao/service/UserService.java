package com.zhengdian.zhaocaibao.service;

import com.zhengdian.zhaocaibao.entity.User;

import java.util.List;

public interface UserService {

    boolean validateUser(User user);

    List<User> selectAllUser();

    int selectUserById(int id);

    boolean register(User user);

    boolean isAlreadyUse(String userPhone);
}
