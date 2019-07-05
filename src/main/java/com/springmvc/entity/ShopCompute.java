package com.springmvc.entity;

import java.util.Date;

public class ShopCompute {
    private Integer id;

    private String type;//所属分类，大分类，电脑，书籍，日用

    private String brand;//品牌

    private Double price;

    private Integer evaluate;//评论人数

    private String getproductdate;//上架时间

    private Float score;//评分

    private String name;//商品名

    private Float size;

    private String cpu;

    private String color;

    private String version;

    private Float weight;//重量

    private String productlocation;//产地

    private String gpu;

    private Boolean istouch;//触控

    private Float thickness;//厚度

    private String typemin;//小分类，笔记本，游戏本

    private String imgurl;




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




    public String getGetproductdate() {
        return getproductdate;
    }




    public void setGetproductdate(Date getproductdate) {
        this.getproductdate = getproductdate.toString();
    }




    public Float getScore() {
        return score;
    }




    public void setScore(Float score) {
        this.score = score;
    }




    public String getName() {
        return name;
    }




    public void setName(String name) {
        this.name = name;
    }




    public Float getSize() {
        return size;
    }




    public void setSize(Float size) {
        this.size = size;
    }




    public String getCpu() {
        return cpu;
    }




    public void setCpu(String cpu) {
        this.cpu = cpu;
    }




    public String getColor() {
        return color;
    }




    public void setColor(String color) {
        this.color = color;
    }




    public String getVersion() {
        return version;
    }




    public void setVersion(String version) {
        this.version = version;
    }




    public Float getWeight() {
        return weight;
    }




    public void setWeight(Float weight) {
        this.weight = weight;
    }




    public String getProductlocation() {
        return productlocation;
    }




    public void setProductlocation(String productlocation) {
        this.productlocation = productlocation;
    }




    public String getGpu() {
        return gpu;
    }




    public void setGpu(String gpu) {
        this.gpu = gpu;
    }




    public Boolean getIstouch() {
        return istouch;
    }




    public void setIstouch(Boolean istouch) {
        this.istouch = istouch;
    }




    public Float getThickness() {
        return thickness;
    }




    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }




    public String getTypemin() {
        return typemin;
    }




    public void setTypemin(String typemin) {
        this.typemin = typemin;
    }




    public String getImgurl() {
        return imgurl;
    }




    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }




    public ShopCompute (Shop shop,Computer computer){
        this.id = computer.getId();
        this.name = computer.getName();
        this.size = computer.getSize();
        this.cpu = computer.getCpu();
        this.gpu = computer.getGpu();
        this.color = computer.getColor();
        this.version = computer.getVersion();
        this.weight = computer.getWeight();
        this.productlocation = computer.getProductlocation();
        this.istouch = computer.getIstouch();
        this.thickness = computer.getThickness();
        this.typemin = computer.getType();//细的分类
        this.imgurl = computer.getImgurl();
        this.type = shop.getBrand();
        this.brand = shop.getBrand();
        this.price = shop.getPrice();
        this.evaluate = shop.getEvaluate();
        this.score = shop.getScore();

    }
}
