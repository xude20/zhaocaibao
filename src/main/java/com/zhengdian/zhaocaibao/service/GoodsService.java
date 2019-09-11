package com.zhengdian.zhaocaibao.service;

import com.zhengdian.zhaocaibao.entity.Goods;

import java.util.List;

public interface GoodsService {
    void addGoods(Goods goods);

    void offGoodsById(int id);

    Goods selectGoodsById(int id);

    void updateGoodsById(Goods goods);

    List<Goods> selectOffGoods(int flag);
}
