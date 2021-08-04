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
public class ShoppingCartDTO implements Serializable{
    private LaptopDTO laptop ;
    private int quantity ;
    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(LaptopDTO laptop, int quantity) {
        this.laptop = laptop;
        this.quantity = quantity;
    }

    public LaptopDTO getLaptop() {
        return laptop;
    }

    public void setLaptop(LaptopDTO laptop) {
        this.laptop = laptop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
