/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.pruebaproyectoventa.persistens;

import edu.uptc.pruebaproyectoventa.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ProductDAO {
    
    private ConnectDB connect;
    
    public ProductDAO(){
        connect = new ConnectDB();
    }
    
    /**
     * Método que retorna un objeto ResultSet con los datos de los Cientes almacenados en la Base de Datos.
     * @return El Conjunto de Resultados
     * @throws SQLException Propaga una Excepción si hay error en la consulta a la Base de Datos.
     */
    
    public ResultSet loadProducts() throws SQLException{
        if( connect.isConnect() ){
            Statement statement = connect.getConnection().createStatement();
            return statement.executeQuery("select * from producto");
        }
        return null;
    }
    
    /**
     * Método que inserta un registro en la Base de Datos
     * @param pro Especifica el objeto a insertar
     * @return El número de registros insertados
     * @throws SQLException Propaga una Excepción si hay error en la consulta a la Base de Datos.
     */

    public int insertProduct( Product pro ) throws SQLException {

        if ( connect.isConnect() ) {
            Statement statement = connect.getConnection().createStatement();
            return statement.executeUpdate("insert into producto values('"+pro.getId()+"','"+pro.getName()+"','"+pro.getStock()+"','"+pro.getPrice()+"')");
        }

        return 0;
    }
    
    public int deleteProduct( String id ){
        if( connect.isConnect( ) ){
            Statement statement;
            try {
                statement = connect.getConnection().createStatement();
                return statement.executeUpdate("delete from prodeucto where idProducto='"+id+"'");
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return 0;
    }
    
}
