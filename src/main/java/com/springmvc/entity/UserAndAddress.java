package com.springmvc.entity;

public class UserAndAddress {
    private User user;
    private Address address;

    public UserAndAddress(User u,Address a){
        this.user=u;
        this.address=a;
    }
    public Address getAddress() {
        return address;
    }

    public User getUser() {
        return user;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

