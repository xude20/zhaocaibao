package com.zhengdian.zhaocaibao.controller;

import com.zhengdian.zhaocaibao.entity.Goods;
import com.zhengdian.zhaocaibao.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@Api
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/add")
    @ApiOperation("新增一条商品记录")
    public String addGoods(Goods goods) {
        goodsService.addGoods(goods);
        return "success";
    }

    @PutMapping("/off")
    @ApiOperation("根据商品id确定下架商品,其实是改变他的状态flag")
    public void offGoodsByid(int id) {
        goodsService.offGoodsById(id);
    }

    @GetMapping("/selectGoodsById")
    @ApiOperation("编辑已经下架的流产的商品前，先进行查询，将内容展示出来")
    public Goods selectGoodsById(int id) {
        Goods goods = goodsService.selectGoodsById(id);
        return goods;
    }

    @PutMapping("/up")
    @ApiOperation("根据商品id将之前下架的商品进行修改上架——编辑")
    public void upGoodsByid(Goods goods) {
        goodsService.updateGoodsById(goods);
    }
}
