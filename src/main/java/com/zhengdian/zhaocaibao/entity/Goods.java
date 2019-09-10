package com.zhengdian.zhaocaibao.entity;

import lombok.Data;

import java.util.Date;

public class Goods {
    private int id;
    private String userPhone;
    private String title;
    private String detail;
    private String imgUrl;
    private String videoUrl;
    private String cTime;
    private String deadLine;
    private int firstPrice;
    private int rangePrice;
    private int advicePrice;
    private int flag;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public int getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(int firstPrice) {
        this.firstPrice = firstPrice;
    }

    public int getRangePrice() {
        return rangePrice;
    }

    public void setRangePrice(int rangePrice) {
        this.rangePrice = rangePrice;
    }

    public int getAdvicePrice() {
        return advicePrice;
    }

    public void setAdvicePrice(int advicePrice) {
        this.advicePrice = advicePrice;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", userPhone='" + userPhone + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", cTime='" + cTime + '\'' +
                ", deadLine='" + deadLine + '\'' +
                ", firstPrice=" + firstPrice +
                ", rangePrice=" + rangePrice +
                ", advicePrice=" + advicePrice +
                ", flag=" + flag +
                '}';
    }
}
