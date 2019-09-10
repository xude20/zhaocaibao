package com.zhengdian.zhaocaibao.controller;

import com.zhengdian.zhaocaibao.entity.Goods;
import com.zhengdian.zhaocaibao.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
