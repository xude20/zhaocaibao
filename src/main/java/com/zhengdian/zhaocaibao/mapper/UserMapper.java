package com.zhengdian.zhaocaibao.mapper;

import com.zhengdian.zhaocaibao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserMapper {
    int validateUser(User user);

    List<User> selectAllUser();

    int selectUserById(int id);

    int isAlreadyUse(String userPhone);

    int register(Map<String, String> map);

    void addCode6(Map<String, String> map);

    int resultOfCode(String userPhone, String code6);
}
