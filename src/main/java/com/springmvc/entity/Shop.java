package com.springmvc.entity;

import java.util.Date;

public class Shop {
    private Integer id;

    private String type;

    private String brand;

    private Double price;

    private Integer evaluate;

    private Date getproductdate;

    private Float score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

    public Date getGetproductdate() {
        return getproductdate;
    }

    public void setGetproductdate(Date getproductdate) {
        this.getproductdate = getproductdate;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}