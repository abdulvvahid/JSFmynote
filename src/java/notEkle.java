/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author abdul
 */
@ManagedBean
@RequestScoped
public class notEkle {

    public int not_id;
    public String not_name, not_not;
    public Date not_date;

    public int getNot_id() {
        return not_id;
    }

    public void setNot_id(int not_id) {
        this.not_id = not_id;
    }

    public String getNot_name() {
        return not_name;
    }

    public void setNot_name(String not_name) {
        this.not_name = not_name;
    }

    public String getNot_not() {
        return not_not;
    }

    public void setNot_not(String not_not) {
        this.not_not = not_not;
    }

    public Date getNot_date() {
        return not_date;
    }

    public void setNot_date(Date not_date) {
        this.not_date = not_date;
    }
    
    
    
    public notEkle() {
    }
    
    public String ekle(){
        DBconnect db = new DBconnect();
        db.connect();
        int i=0;
        try{
            PreparedStatement st = db.con.prepareStatement("insert into nott(not_id,not_adi,not_tarih,not_not) values(?,?,?,?)");
            st.setInt(1, not_id);
            st.setString(2, not_name);
            if (not_date == null) {
                st.setNull(3, java.sql.Types.DATE);
            } else {
                st.setDate(3, new java.sql.Date(not_date.getTime()));
            }
            st.setString(4, not_not);
            i = st.executeUpdate();
        }catch(SQLException e){
            throw new FacesException(e);
        }
        if(i>0){
            System.out.println("Kayıt Basarılı");
            return "/secured/securedPage?faces-redirect=true";
        }else{
            System.out.println("Kayıt Başarısız");
            return "/secured/notEkle?faces-redirect=true";
        }
    }
}
