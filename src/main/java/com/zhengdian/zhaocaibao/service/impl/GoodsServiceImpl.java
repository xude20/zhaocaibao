package com.zhengdian.zhaocaibao.service.impl;

import com.zhengdian.zhaocaibao.entity.Goods;
import com.zhengdian.zhaocaibao.mapper.GoodsMapper;
import com.zhengdian.zhaocaibao.service.GoodsService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        goodsMapper.offGoodsById(id);
    }

    @Override
    public Goods selectGoodsById(int id) {
        Goods goods = goodsMapper.selectGoodsById(id);
        return goods;
    }

    @Override
    public void updateGoodsById(Goods goods) {
        goodsMapper.updateGoodsById(goods);
    }

    @Override
    public List<Goods> selectOffGoods(int flag) {
        List<Goods> goodsList = goodsMapper.selectOffGoods(flag);
        return goodsList;
    }
}
