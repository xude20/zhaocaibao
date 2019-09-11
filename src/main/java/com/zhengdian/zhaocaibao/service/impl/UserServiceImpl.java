package com.zhengdian.zhaocaibao.service.impl;

import com.zhengdian.zhaocaibao.entity.User;
import com.zhengdian.zhaocaibao.mapper.UserMapper;
import com.zhengdian.zhaocaibao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean validateUser(User user) {
        int result = userMapper.validateUser(user);
        return result == 1 ? true : false;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> list = userMapper.selectAllUser();
        return list;
    }

    @Override
    public int selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public boolean isAlreadyUse(String userPhone) {
        int result = userMapper.isAlreadyUse(userPhone);
        return result == 1 ? true : false;
    }

    @Override
    public boolean register(Map<String, String> map) {
        int result = userMapper.register(map);
        return result == 1 ? true : false;
    }

    @Override
    public void addCode6(Map<String, String> map) {
        userMapper.addCode6(map);
    }

    @Override
    public int resultOfCode(String userPhone, String code6) {
        return userMapper.resultOfCode(userPhone,code6);
    }
}
