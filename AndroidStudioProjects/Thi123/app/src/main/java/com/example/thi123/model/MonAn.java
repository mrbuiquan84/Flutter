package com.example.thi123.model;

import java.io.Serializable;

public class MonAn implements Serializable {
    private int maMon;
    private String tenMon;
    private float giaDat;
    private String ngayDat;

    public MonAn() {
    }

    public MonAn(int maMon, String tenMon, float giaDat, String ngayDat) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.giaDat = giaDat;
        this.ngayDat = ngayDat;
    }

    public MonAn(String tenMon, float giaDat, String ngayDat) {
        this.tenMon = tenMon;
        this.giaDat = giaDat;
        this.ngayDat = ngayDat;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public float getGiaDat() {
        return giaDat;
    }

    public void setGiaDat(float giaDat) {
        this.giaDat = giaDat;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }
}
