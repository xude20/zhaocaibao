package com.zhengdian.zhaocaibao.controller;

import com.zhengdian.zhaocaibao.common.Constant;
import com.zhengdian.zhaocaibao.entity.User;
import com.zhengdian.zhaocaibao.service.UserService;
import com.zhengdian.zhaocaibao.utils.JedisUtil;
import com.zhengdian.zhaocaibao.utils.JuheMesUtil;
import com.zhengdian.zhaocaibao.utils.MD5Utils;
import com.zhengdian.zhaocaibao.utils.RandomCode6;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api("用户控制层")
public class UserController {

    @Autowired
    private UserService userService;

    private JedisUtil jedisUtil = JedisUtil.getInstance();

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
    public String login(User user, HttpSession session){
        //session判断自动登录
        if (session.getAttribute("userPhone") != null && session.getAttribute("password") != null) {
            return "success";
        }

        //密码进行加密比对
        user.setPassword(MD5Utils.getMd5(user.getPassword()));
        boolean result = userService.validateUser(user);
        if (result) {
            session.setAttribute("userPhone",user.getUserPhone());
            session.setAttribute("password",user.getPassword());
        }
        return "success";
    }

    @GetMapping("/isAlreadyUse")
    @ApiOperation("前端检测手机号是否已经注册")
    public boolean isAlreadyUse(String userPhone) {
        boolean result = userService.isAlreadyUse(userPhone);
        return result;
    }

    @PostMapping("/getValidatecode")
    @ApiOperation("获取短信验证码")
    public void getCode(String userPhone) throws IOException {
        String code6 = RandomCode6.getRandNum(6);
        System.out.println(userPhone+"___"+code6);
        //暂时先放到数据库中，redis还没布置
//        Map<String,String> map = new HashMap<>();
//        map.put("userPhone",userPhone);
//        map.put("code6",code6);
//        userService.addCode6(map);

        //将手机号和短信验证码放入redis中，存储为String类型

        //如果redis中存在userphoone，那么删除掉，因为用户重新获取了
        if (jedisUtil.get(userPhone) != null) {
            jedisUtil.del(userPhone);
        }
        //存入，并设置过期时间为15分钟
        jedisUtil.setExpire(userPhone,code6,900);

        //這裏是使用方法調用第三方接口，手機獲取驗證碼
        JuheMesUtil.mobileQuery(userPhone,code6);
    }

    @PostMapping("/register")
    @ApiOperation("这里是点击注册的方法")
    public boolean register(String userPhone,String password,String petName,String code6) {
        //验证之前，先进行验证码的验证，如果验证失败，那么返回验证码错误
        //这里是数据库存储的，不用了，我们用redis
//        int result = userService.resultOfCode(userPhone,code6);
//        if (result != 1) {
//            return false;
        if (!jedisUtil.get(userPhone).equals(code6)) {
            return false;
        } else {
            //创建一个map集合放入需要存入数据库的资源，日期选择现在
            Map<String, String> map = new HashMap<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = dateFormat.format(new Date());

            //密码进行加密处理
            String passwordPlus = MD5Utils.getMd5(password);

            //封装成 map
            map.put("userPhone", userPhone);
            map.put("password", passwordPlus);
            map.put("petName", petName);
            map.put("cTime", format);
            boolean res = userService.register(map);
            return res;
        }
    }
}
