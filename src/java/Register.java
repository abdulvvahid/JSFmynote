import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Register {
    
    private String kadi,ksifre;
    int i =0;

    public String getKadi() {
        return kadi;
    }

    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

    public String getKsifre() {
        return ksifre;
    }

    public void setKsifre(String ksifre) {
        this.ksifre = ksifre;
    }
    
    public Register() {
    }
    
    public String kayit(){
        DBconnect db = new DBconnect();
        db.connect();
        try{
            PreparedStatement st = db.con.prepareStatement("insert into kullanici(kullanici_id,kullanici_pass) values(?,?)");
            st.setString(1, kadi);
            st.setString(2, ksifre);
            i = st.executeUpdate();
        }catch(SQLException e){
            throw new FacesException(e);
        }
        if(i>0){
            System.out.println("Kayıt Basarılı");
            return "/login?faces-redirect=true";
        }else{
            System.out.println("Kayıt Başarısız");
            return "/register?faces-redirect=true";
        }
    }
    
}
