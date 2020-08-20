/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named
@SessionScoped
public class LoginController implements Serializable{
    
    private User user;

    public User getUser() {
        if( this.user == null)
            this.user = new User();
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    
    public String login(){
        
        int i=0;
        DBconnect db = new DBconnect();
        db.connect();
        try{
        Statement stmt = db.con.createStatement();
            ResultSet rs = stmt.executeQuery("select kullanici_id,kullanici_pass from kullanici");
            while (rs.next()){
                if((this.user.getUsername() == null ? rs.getString(1) == null : this.user.getUsername().equals(rs.getString(1))) && (this.user.getPassword() == null ? rs.getString(2) == null : this.user.getPassword().equals(rs.getString(2)))){
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user",this.user);
                    return "/secured/securedPage?faces-redirect=true"; 
                }
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Kullanıcı veya Şifre"));
        return "/login";
    }     

    
    public LoginController() {
    }
    
}
