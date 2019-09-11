package com.zhengdian.zhaocaibao.common;

import org.springframework.context.annotation.Configuration;

public class Constant {

    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    //配置您申请的KEY
    public static final String APPKEY = "key="+"ed3352a7a8c85c09672e858276e87f17";
    public static final String TPL_ID = "tpl_id="+"185534"; //模板id
    public static final String TPL_VALUE = "tpl_value=";
    public static final String URL = "http://v.juhe.cn/sms/send";
    public static final String MOBILE = "mobile=";
}
