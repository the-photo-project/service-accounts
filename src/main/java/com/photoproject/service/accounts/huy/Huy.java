package com.photoproject.service.accounts.huy;

public class Huy {

    private final int ngay;
    private final int h;
    private final int m;
    private final int s;

    public Huy(int ngay, int h, int m, int s) {
        this.ngay = ngay;
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public int getNgay() {
        return ngay;
    }
    public int getH() {
        return h;
    }
    public int getM() {
        return m;
    }
    public int getS() {
        return s;
    }
}
