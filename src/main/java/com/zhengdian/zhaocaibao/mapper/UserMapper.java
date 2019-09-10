package com.zhengdian.zhaocaibao.mapper;

import com.zhengdian.zhaocaibao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    int validateUser(User user);

    List<User> selectAllUser();

    int selectUserById(int id);

    int register(User user);

    int isAlreadyUse(String userPhone);
}
