package com.zhengdian.zhaocaibao.controller;

import com.zhengdian.zhaocaibao.entity.Aution;
import com.zhengdian.zhaocaibao.entity.Goods;
import com.zhengdian.zhaocaibao.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/goods")
@Api
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/save")
    @ApiOperation("新增一条商品记录,新增记录的时间不用传参")
    public String addGoods(Goods goods) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        goods.setcTime(format);
        System.out.println(goods);
        if (goods.getId() == 0) {
            goodsService.addGoods(goods);
        } else {
            goodsService.updateGoodsById(goods);
        }
        return "success";
    }

    @PutMapping("/off")
    @ApiOperation("根据商品id确定下架商品,其实是改变他的状态flag")
    public void offGoodsByid(int id) {
        goodsService.offGoodsById(id);
    }

    @GetMapping("/selectMyGoods")
    @ApiOperation("展示所有商品——正在挂售flag=1/流拍商品flag=2/完成拍卖商品flag=3，前端点击分类的按钮后传参")
    public List<Goods> selectOffGoods(int flag) {
        List<Goods> goodsList = goodsService.selectOffGoods(flag);
        return goodsList;
    }

    @GetMapping("/selectGoodsById")
    @ApiOperation("查询某一商品，将详细内容展示出来")
    public Goods selectGoodsById(int id) {
        Goods goods = goodsService.selectGoodsById(id);
        return goods;
    }

    @PostMapping("/addPrice")
    @ApiOperation("顶价，每次顶价将数据存放在redis中.需要传递商品id、手机号、价格即可")
    public String addPrice(Aution aution) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        aution.setcTime(format);
        //将数据存储到redis中，商品id作为key；毫秒级时间戳＋6位随机数作为feild；json字符串（手机号、时间、价格）作为value
        //每次插入之前，先做判断，如果插入的价格低于当前最高价格，那么禁止插入，提示刷新后重试
        
//        goodsService.addPrice
    }

}
