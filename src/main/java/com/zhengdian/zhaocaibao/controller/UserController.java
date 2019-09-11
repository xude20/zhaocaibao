package com.zhengdian.zhaocaibao.controller;

import com.zhengdian.zhaocaibao.common.Constant;
import com.zhengdian.zhaocaibao.entity.User;
import com.zhengdian.zhaocaibao.service.UserService;
import com.zhengdian.zhaocaibao.utils.RandomCode6;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/getValidatecode")
    @ApiOperation("获取短信验证码")
    public void getCode(String userPhone) throws IOException {
        String code6 = RandomCode6.getRandNum(6);
        System.out.println(userPhone+"___"+code6);
        //暂时先放到数据库中，redis还没布置
        Map<String,String> map = new HashMap<>();
        map.put("userPhone",userPhone);
        map.put("code6",code6);
        userService.addCode6(map);

        //這裏是使用方法調用第三方接口，手機獲取驗證碼
        String str_code = URLEncoder.encode("#code#=" + code6, "UTF-8");
        System.out.println(str_code);
        String str_url = Constant.URL+"?"+Constant.MOBILE+userPhone+"&"+Constant.TPL_ID+"&"+Constant.TPL_VALUE+str_code+"&"+Constant.APPKEY;
        URL url = new URL(str_url);
        System.out.println(url);

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.connect();

        /*URLConnection connection = url.openConnection();
        connection.connect();*/
    }

    @PostMapping("/register")
    @ApiOperation("这里是点击注册的方法")
    public boolean register(String userPhone,String password,String petName,String code6) {
        //验证之前，先进行验证码的验证，如果验证失败，那么返回验证码错误
        int result = userService.resultOfCode(userPhone,code6);
        if (result != 1) {
            return false;
        } else {
            //创建一个map集合放入需要存入数据库的资源，日期选择现在
            Map<String, String> map = new HashMap<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = dateFormat.format(new Date());
            map.put("userPhone", userPhone);
            map.put("password", password);
            map.put("petName", petName);
            map.put("cTime", format);
            boolean res = userService.register(map);
            return res;
        }
    }
}
