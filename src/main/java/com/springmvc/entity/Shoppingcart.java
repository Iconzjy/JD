package com.springmvc.entity;

public class Shoppingcart {
    private Integer primarykey;

    private Integer shoppingid;

    private Integer userid;

    private Integer number;

    private Double price;

    private Double allprice;

    private String trading;

    private Double freight;

    public Integer getPrimarykey() {
        return primarykey;
    }

    public void setPrimarykey(Integer primarykey) {
        this.primarykey = primarykey;
    }

    public Integer getShoppingid() {
        return shoppingid;
    }

    public void setShoppingid(Integer shoppingid) {
        this.shoppingid = shoppingid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }

    public String getTrading() {
        return trading;
    }

    public void setTrading(String trading) {
        this.trading = trading;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }
}