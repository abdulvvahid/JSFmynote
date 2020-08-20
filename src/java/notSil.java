/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author abdul
 */
@ManagedBean
@RequestScoped
public class notSil {

    
    public void Sil(Nott t){
        
        DBconnect db = new DBconnect();
        db.connect();
       
        try{
            Statement st = db.con.createStatement();
            st.executeUpdate("delete from nott where not_id="+t.getNot_id());
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
        
}
