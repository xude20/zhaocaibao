package com.zhengdian.zhaocaibao.service.impl;

import com.zhengdian.zhaocaibao.entity.User;
import com.zhengdian.zhaocaibao.mapper.UserMapper;
import com.zhengdian.zhaocaibao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean register(User user) {
        int result = userMapper.register(user);
        return result == 1 ? true : false;
    }

    @Override
    public boolean isAlreadyUse(String userPhone) {
        int result = userMapper.isAlreadyUse(userPhone);
        return result == 1 ? true : false;
    }
}
