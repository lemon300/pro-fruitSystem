package com.atguigu.fruit.pojo;

import java.math.BigDecimal;

/**
 * @author twj28
 * @create 2022 2022/4/7 15:03
 */
public class Fruit {
    private int fid;
    private String fname;
    private BigDecimal price;
    private int fcount;
    private String remark;

    public Fruit(String fname, BigDecimal price, int fcount, String remark) {
        this.fname = fname;
        this.price = price;
        this.fcount = fcount;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", price=" + price +
                ", fcount=" + fcount +
                ", remark='" + remark + '\'' +
                '}';
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Fruit(int fid, String fname, BigDecimal price, int fcount, String remark) {
        this.fid = fid;
        this.fname = fname;
        this.price = price;
        this.fcount = fcount;
        this.remark = remark;
    }

    public Fruit() {
    }
    public void showFruit(){
        System.out.println(fid + "\t\t" + fname + "\t\t" + price + "\t\t" + fcount + "\t\t" + remark);
    }
}
