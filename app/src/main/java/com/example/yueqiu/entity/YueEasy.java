package com.example.yueqiu.entity;

import cn.bmob.v3.BmobObject;

public class YueEasy extends BmobObject {
    private int mqrs;
    private String mwz;
    private String msj;

    public int getQrs() {
        return mqrs;
    }

    public String getWz() {
        return mwz;
    }

    public String getSj() {
        return msj;
    }

    public void setMqrs(int mqrs) {
        this.mqrs = mqrs;
    }

    public void setMwz(String mwz) {
        this.mwz = mwz;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
}
