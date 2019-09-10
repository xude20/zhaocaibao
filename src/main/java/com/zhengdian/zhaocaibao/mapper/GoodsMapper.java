package com.zhengdian.zhaocaibao.mapper;

import com.zhengdian.zhaocaibao.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GoodsMapper {
    void addGoods(Goods goods);
}
