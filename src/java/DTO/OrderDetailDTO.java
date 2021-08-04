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
public class OrderDetailDTO implements Serializable{
    private int orderDetailId;
    private LaptopDTO laptop;    
    private OrderDTO order ;
    int quantity;

    public OrderDetailDTO() {
    }
    public OrderDetailDTO(int orderDetailId,LaptopDTO laptop, OrderDTO order, int quantity) {
        this.orderDetailId = orderDetailId;
        this.laptop = laptop;
        this.order = order;
        this.quantity = quantity;
        
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    
    public LaptopDTO getLaptop() {
        return laptop;
    }

    public void setLaptop(LaptopDTO laptop) {
        this.laptop = laptop;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
