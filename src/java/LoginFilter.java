
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class LoginFilter implements Filter{
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws  IOException, ServletException{
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String url = req.getRequestURI();
        
        User u = (User) req.getSession().getAttribute("valid_user");
        
        if (u == null){
            
            if( url.contains("secured") || url.contains("logout")){
                res.sendRedirect(req.getContextPath()+"/login.xhtml");
            }else{
                chain.doFilter(request, response);
            }
            
        }else{
            if( url.contains("register") || url.contains("login")){
                res.sendRedirect(req.getContextPath()+"/secured/securedPage.xhtml");
            }else if( url.contains("logout")){
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath()+"/index.xhtml");
                
            }else{
                chain.doFilter(request, response);
            }
        }
    }
}
