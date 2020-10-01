/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.pruebaproyectoventa.persistens;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Wilmar
 */
public class ConnectDBTest {
    
    private ConnectDB connect;
    
    private void setup(){
        connect = new ConnectDB();
    }

    @Test
    public void testConnect() {
        setup();
        assertTrue( connect.isConnect() );
    }
    
}
