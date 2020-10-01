/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.pruebaproyectoventa.persistens;

import edu.uptc.pruebaproyectoventa.model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author usuario
 */
public class CustomerDAO {
    
    private ConnectDB connect;

    public CustomerDAO() {
        connect = new ConnectDB();
    }
    
    /**
     * Método que retorna un objeto ResultSet con los datos de los Cientes almacenados en la Base de Datos.
     * @return El Conjunto de Resultados
     * @throws SQLException Propaga una Excepción si hay error en la consulta a la Base de Datos.
     */
    
    public ResultSet loadCustomers() throws SQLException{
        if( connect.isConnect() ){
            Statement statement = connect.getConnection().createStatement();
            return statement.executeQuery("select * from cliente");
        }
        
        return null;
    }
    
    /**
     * Método que inserta un registro en la Base de Datos
     * @param cst Especifica el objeto a insertar
     * @return El número de registros insertados
     * @throws SQLException Propaga una Excepción si hay error en la consulta a la Base de Datos.
     */

    public int insertCustomer( Customer cst ) throws SQLException {
        
        if ( connect.isConnect() ) {
            Statement statement = connect.getConnection().createStatement();
            return statement.executeUpdate("insert into cliente values('"+cst.getId()+"','"+cst.getName()+"','"+cst.getLastName()+"','"+cst.getDireccion()+"','"+cst.getPhone()+"')");
        }

        return 0;
    }
    
    public int deleteCustomer( String id ){
        if( connect.isConnect( ) ){
            Statement statement;
            try {
                statement = connect.getConnection().createStatement();
                return statement.executeUpdate("delete from cliente where idCliente='"+id+"'");
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return 0;
    }
    
}
