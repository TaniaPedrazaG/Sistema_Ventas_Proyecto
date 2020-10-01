/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.pruebaproyectoventa.model;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Sale {
    /*No estoy segura que sea as...*/
    private String id;
    private String name;
    private String idProduct;
    private int amount;
    private int price;

    public Sale() {
        
    }

    public Sale(String id, String name, String idProduct, int amount, int price) {
        this.id = id;
        this.name = name;
        this.idProduct = idProduct;
        this.amount = amount;
        this.price = price;
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

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", name=" + name + ", idProduct=" + idProduct + ", amount=" + amount + ", price=" + price + '}';
    }

}
