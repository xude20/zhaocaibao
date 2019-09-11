package com.zhengdian.zhaocaibao.utils;

import com.zhengdian.zhaocaibao.common.Constant;

import java.util.HashMap;
import java.util.Map;

public class Message {
    //2.发送短信
    public static void getRequest2(){
        String result =null;
        String url ="http://v.juhe.cn/sms/send";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("mobile","");//接收短信的手机号码
        params.put("tpl_id","");//短信模板ID，请参考个人中心短信模板设置
        params.put("tpl_value","");//变量名和变量值对。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，<a href="http://www.juhe.cn/news/index/id/50" target="_blank">详细说明></a>
        params.put("key", Constant.APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml或json，默认json


    }
}
