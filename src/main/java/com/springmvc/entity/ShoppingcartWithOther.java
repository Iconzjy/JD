package com.springmvc.entity;

public class ShoppingcartWithOther {

    private Shoppingcart shoppingcart;

    private Shop shop;

    private  Computer computer;

    public ShoppingcartWithOther(Shoppingcart sc,Shop sh,Computer c){
        this.shoppingcart=sc;
        this.shop=sh;
        this.computer=c;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Shoppingcart getShoppingcart() {
        return shoppingcart;
    }

    public void setShoppingcart(Shoppingcart shoppingcart) {
        this.shoppingcart = shoppingcart;
    }
}
