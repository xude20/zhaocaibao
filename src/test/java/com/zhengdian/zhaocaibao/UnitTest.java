package com.zhengdian.zhaocaibao;

import com.zhengdian.zhaocaibao.entity.User;
import com.zhengdian.zhaocaibao.service.UserService;
import com.zhengdian.zhaocaibao.service.impl.UserServiceImpl;
import com.zhengdian.zhaocaibao.utils.RandomCode6;
import org.junit.Before;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Test
    /**
     * 测试6为验证码的使用
     */
    public void testValidatecode() {
        String randNum = RandomCode6.getRandNum(6);
        System.out.println(randNum);
    }

    @Test
    public void timeTest() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        System.out.println(format);

        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testConnection() throws IOException {
        URL url = new URL("http://v.juhe.cn/sms/send?mobile=18339956503&tpl_id=185534&tpl_value=%23code%23%3D509721&key=ed3352a7a8c85c09672e858276e87f17");
//        String str_url = "https://www.baidu.com/";
//        URL url = new URL(str_url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();

    }
}
