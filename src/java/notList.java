/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class notList {
    
    public notList() {
    }
    
    ArrayList<Nott> notListesi = new ArrayList<>();

    public ArrayList<Nott> getNotListesi() {
        return notListesi;
    }

    public void setNotListesi(ArrayList<Nott> notListesi) {
        this.notListesi = notListesi;
    }
    
    
   
    
    public ArrayList<Nott> select(){
        DBconnect db = new DBconnect();
        db.connect();
        try{
            Statement st = db.con.createStatement();
            ResultSet rs = st.executeQuery("select * from nott");
            notListesi.clear();
            while (rs.next()){
                Nott n = new Nott();
                n.setNot_id(rs.getInt("not_id"));
                n.setNot_name(rs.getString("not_adi"));
                n.setNot_date(rs.getDate("not_tarih"));
                n.setNot_not(rs.getString("not_not"));
                
                notListesi.add(n);
            }
            st.close();
        }catch(SQLException e){
            
        }
        
        return notListesi;
    }
    
    
}
