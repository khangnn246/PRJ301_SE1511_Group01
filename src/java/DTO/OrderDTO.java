/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author khang
 */
public class OrderDTO implements Serializable{
    private int orderid;
    private UserDTO user ;
    private String address ;
    private float totalprice;

    public OrderDTO() {
    }

    public OrderDTO(int orderDTO, UserDTO user, String Address, float totalprice) {
        this.orderid = orderDTO;
        this.user = user;
        this.address = Address;
        this.totalprice = totalprice;
    }

    public int getorderid() {
        return orderid;
    }

    public void setorderid(int orderid) {
        this.orderid = orderid;
    }
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }
    
}
