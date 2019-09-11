package com.zhengdian.zhaocaibao.service.impl;

import com.zhengdian.zhaocaibao.entity.Goods;
import com.zhengdian.zhaocaibao.mapper.GoodsMapper;
import com.zhengdian.zhaocaibao.service.GoodsService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
    }

    @Override
    public void offGoodsById(int id) {

    }

    @Override
    public Goods selectGoodsById(int id) {
        return null;
    }

    @Override
    public void updateGoodsById(Goods goods) {

    }
}
