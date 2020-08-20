
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Nott {
    private int not_id;
    private String not_name;
    private Date not_date;
    private String not_not;


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

    public Date getNot_date() {
        return not_date;
    }

    public void setNot_date(Date not_date) {
        this.not_date = not_date;
    }

    public String getNot_not() {
        return not_not;
    }

    public void setNot_not(String not_not) {
        this.not_not = not_not;
    }

    public Nott(int not_id, String not_name, Date not_date, String not_not) {
        this.not_id = not_id;
        this.not_name = not_name;
        this.not_date = not_date;
        this.not_not = not_not;
    }
    
    public Nott(){
        
    }
    
}
