/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.pruebaproyectoventa.model;

import edu.uptc.pruebaproyectoventa.persistens.CustomerDAO;
import edu.uptc.pruebaproyectoventa.persistens.ProductDAO;
import edu.uptc.pruebaproyectoventa.persistens.SaleDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author usuario
 */
public class Management {

    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Sale> sales;
    private CustomerDAO customerDAO;
    private ProductDAO productDAO;
    private SaleDAO saleDAO;

    /*No estoy segura si iria lo de JSON, debido a que como lo vamos es a trabajar con BD*/
    public Management() {
        customers = new ArrayList<>();
        products = new ArrayList<>();
        sales = new ArrayList<>();
        saleDAO = new SaleDAO();
        customerDAO = new CustomerDAO();
        productDAO = new ProductDAO();
    }

    /**
     * Método que carga en el arreglo los Clientes que se encuentran en una
     * Tabla de una Base de Datos
     *
     * @throws SQLException Propaga una Excepción si el gestor de la base de
     * datos retorna algún tipo de error.
     */
    public void loadCustomersDB() throws SQLException {
        ResultSet rs = customerDAO.loadCustomers();

        while (rs.next()) {

            String code = rs.getString("idCliente");
            String name = rs.getString("nombres");
            String lastName = rs.getString("apellidos");
            String dir = rs.getString("direccion");
            int phone = rs.getInt("telefono");

            customers.add(new Customer(code, name, lastName, dir, phone));
        }
    }

    public void loadProductsDB() throws SQLException{
        ResultSet rs = productDAO.loadProducts();
        
        while ( rs.next() ) {            
            String code = rs.getString("idProducto");
            String name = rs.getString( "nombre" );
            int price = rs.getInt( "precio" );
            int stock = rs.getInt( "stock" );
            
            products.add( new Product(code, name, price, stock) );
        }
    }
    
    public void loadSalesDB() throws SQLException{
        ResultSet rs = saleDAO.loadVentas();
        
        while ( rs.next() ) {            
            String id = rs.getString( "idVenta" );
            String idCustomer = rs.getString( "idCliente" );
            String idProduct = rs.getString( "idProducto" );
            int cant = rs.getInt( "cantidad" );
            int precio = rs.getInt( "precio" );
            
            sales.add( new Sale(id, idCustomer, idProduct, cant, precio) );
        }
    }
    
    /**
     * *
     * Método que busca un Cliente por código
     *
     * @param code Parámeto de entrada que especifica el código del cliente a
     * buscar
     * @return Un objeto Cliente si existe, si no, retorna null
     */
    public Customer findCustomer(String code) {
        for (Customer customer : customers) {
            if (code.compareTo(customer.getId()) == 0) {
                return customer;
            }
        }

        return null;
    }

    /**
     * *
     * Método que retorna el Arreglo de Departamentos
     *
     * @return Un ArrayList de Department
     */
    public ArrayList<Customer> getCustomers() {

        Collections.sort( customers, (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());

        });

        return (ArrayList<Customer>) customers.clone();

    }
    
    public ArrayList<Product> getProducts() {

        Collections.sort( products, (o1, o2) -> {
            return o1.getId().compareTo(o2.getId());

        });

        return (ArrayList<Product>) products.clone();

    }
    
    public ArrayList<Sale> getSales() {

        Collections.sort( sales, (o1, o2) -> {
            return o1.getId().compareTo(o2.getId());

        });

        return (ArrayList<Sale>) sales.clone();

    }

}
