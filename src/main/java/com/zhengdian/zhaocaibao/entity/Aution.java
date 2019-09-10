package com.zhengdian.zhaocaibao.entity;

import lombok.Data;

import java.util.Date;

public class Aution {
    private int id;
    private String userPhone;
    private int goodsId;
    private String cTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "Aution{" +
                "id=" + id +
                ", userPhone='" + userPhone + '\'' +
                ", goodsId=" + goodsId +
                ", cTime='" + cTime + '\'' +
                '}';
    }
}
