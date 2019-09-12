package com.zhengdian.zhaocaibao;

import com.zhengdian.zhaocaibao.entity.Aution;
import com.zhengdian.zhaocaibao.entity.Goods;
import com.zhengdian.zhaocaibao.utils.JedisUtil;
import com.zhengdian.zhaocaibao.utils.SerializeUtil;
import net.sf.json.JSON;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RedisTest {

    private JedisUtil jedisUtil = JedisUtil.getInstance();

    @Test
    public void addRedis() {
        Aution aution = new Aution();
        aution.setcTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        aution.setGoodsId(1);
        aution.setId(12);
        aution.setUserPhone("123456");
        jedisUtil.set("ss",aution.toString());
        System.out.println(jedisUtil.get("ss"));
    }

    @Test
    public void delRedis() {
        jedisUtil.del("zhengdian");
        System.out.println(jedisUtil.get("zhengdian"));
    }

    /**
     * hash类型是否存在
     */
    @Test
    public void exitsHashKey() {
//        jedisUtil.hset("food","fruit","apple");
        jedisUtil.expire("food",100);
        System.out.println(jedisUtil.ttl("food"));
        System.out.println(jedisUtil.hvals("food"));
        if (jedisUtil.exists("food")) {
            System.out.println("存在");
        } else {
            System.err.println("不存在");
        }
    }
}
