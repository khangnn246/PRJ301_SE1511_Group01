/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.sql.Date;
import java.text.DecimalFormat;

/**
 *
 * @author khang
 */
public class LaptopDTO implements Serializable{
    private int id;
    private String name ;
    private float price ;
    private String CPU;
    private String ram;
    private String screen ;
    private String graphic;
    private String disk ;
    private String oS ;
    private float weight;
    private String region;
    private int year;
    private String formatPrice1 = formatPrice();
    public LaptopDTO() {
    }

    public LaptopDTO(int id, String name, float price, String CPU, String ram, String screen, String graphic, String disk, String oS, float weight, String region, int year) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.CPU = CPU;
        this.ram = ram;
        this.screen = screen;
        this.graphic = graphic;
        this.disk = disk;
        this.oS = oS;
        this.weight = weight;
        this.region = region;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getoS() {
        return oS;
    }

    public void setoS(String oS) {
        this.oS = oS;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return id + "=" + 
                name + "=" + 
                price + "=" + 
                CPU + "=" + 
                ram + "=" + 
                screen + "=" + 
                graphic + "=" + 
                disk + "=" + 
                oS + "=" + 
                weight + "=" + 
                region + "=" + 
                year;
    }
    public String formatPrice (){
        String pattern = "###,######.##";
        DecimalFormat decimalformat = new DecimalFormat(pattern);
        String format = decimalformat.format(price);
        return format;
    }
    
}
