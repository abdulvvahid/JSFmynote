/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;

/**
 *
 * @author behram123
 */
public class DBconnect {
    public Connection con;
      
    public Connection connect(){
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            System.out.println("Bağlantı oluşturuldu");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mynote","APP","APP");
        }catch(Exception e){
            System.out.println("Bağlantı oluşturulamadı");
        }
        return con;
    }       
}


