/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.pruebaproyectoventa.persistens;

import edu.uptc.pruebaproyectoventa.model.Sale;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class SaleDAO {
    
    private ConnectDB connect;

    public SaleDAO(){
        connect = new ConnectDB();
    }
    
    /**
     * Método que retorna un objeto ResultSet con los datos de los Cientes almacenados en la Base de Datos.
     * @return El Conjunto de Resultados
     * @throws SQLException Propaga una Excepción si hay error en la consulta a la Base de Datos.
     */
    
    public ResultSet loadVentas() throws SQLException{
        if(connect.isConnect()){Statement statement = connect.getConnection().createStatement();
            return statement.executeQuery("select * from venta");
        }
        return null;
    }
    
    /**
     * Método que inserta un registro en la Base de Datos
     * @param sale Especifica el objeto a insertar
     * @return El número de registros insertados
     * @throws SQLException Propaga una Excepción si hay error en la consulta a la Base de Datos.
     */

    public int insertProduct( Sale sale ) throws SQLException {
        
        if ( connect.isConnect() ) {
            Statement statement = connect.getConnection().createStatement();
            return statement.executeUpdate("insert into venta values('"+sale.getId()+"','"+sale.getName()+"','"+sale.getIdProduct()+"','"+sale.getAmount()+"','"+sale.getPrice()+"')");
        }

        return 0;
    }
    
    
}
