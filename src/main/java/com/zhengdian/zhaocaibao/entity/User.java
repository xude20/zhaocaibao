package com.zhengdian.zhaocaibao.entity;

import lombok.Data;


public class User {
    private int id;
    private String userPhone;
    private String password;
    private String petName;
    private String birthday;
    private String imgUrl;
    private int flag;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userPhone='" + userPhone + '\'' +
                ", password='" + password + '\'' +
                ", petName='" + petName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", flag=" + flag +
                ", cTime='" + cTime + '\'' +
                '}';
    }
}
