package com.zhengdian.zhaocaibao.service;

import com.zhengdian.zhaocaibao.entity.Goods;

public interface GoodsService {
    void addGoods(Goods goods);

    void offGoodsById(int id);

    Goods selectGoodsById(int id);

    void updateGoodsById(Goods goods);
}
