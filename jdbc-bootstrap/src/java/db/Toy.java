/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Date;

/**
 *
 * @author Nguyen Tien Kha
 * Entity class = lop tuong ung voi table = la 1 javaBean
 * Toy = ToyDTO
 */
public class Toy {

    private String id;
    private String name;
    private double price;
    private Date expDate;
    private String brand;

    public Toy() {
    }

    public Toy(String id, String name, double price, Date expDate, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expDate = expDate;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


}
