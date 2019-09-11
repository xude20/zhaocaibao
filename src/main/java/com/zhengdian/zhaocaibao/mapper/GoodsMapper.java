package com.zhengdian.zhaocaibao.mapper;

import com.zhengdian.zhaocaibao.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsMapper {
    void addGoods(Goods goods);

    void offGoodsById(int id);

    List<Goods> selectOffGoods(int flag);

    Goods selectGoodsById(int id);

    void updateGoodsById(Goods goods);
}
