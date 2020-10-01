/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.pruebaproyectoventa.model;

/**
 *
 * @author usuario
 */
public class Customer {
    
    private String id;
    private String name;
    private String lastName;
    private String direccion;
    private int phone;

    public Customer(String id, String name, String lastName, String direccion, int phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.direccion = direccion;
        this.phone = phone;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", direccion=" + direccion + ", phone=" + phone + '}';
    }
    
}
