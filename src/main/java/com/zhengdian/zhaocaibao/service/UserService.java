package com.zhengdian.zhaocaibao.service;

import com.zhengdian.zhaocaibao.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    boolean validateUser(User user);

    List<User> selectAllUser();

    int selectUserById(int id);
    
    boolean isAlreadyUse(String userPhone);

    boolean register(Map<String, String> map);

    void addCode6(Map<String, String> map);

    int resultOfCode(String userPhone, String code6);
}
