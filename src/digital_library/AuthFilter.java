package digital_library;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/faces/admin/*"})
public class AuthFilter implements Filter {
	
    public AuthFilter() {
    	
    }
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	try {
            // check whether session variable is set
            HttpServletRequest Request = (HttpServletRequest) request;
            HttpServletResponse Response = (HttpServletResponse) response;
            HttpSession Session = Request.getSession(false);
            
            // allow user to proceed if url is login.xhtml or user logged in
            String requestURI = Request.getRequestURI();
            
            if (requestURI.indexOf("/login.xhtml") >= 0 || (Session != null && Session.getAttribute("username") != null) || requestURI.contains("javax.faces.resource")) {
            	chain.doFilter(request, response);
            } else {
            	// redirect to login page.
            	Response.sendRedirect(Request.getContextPath() + "/faces/admin/login.xhtml");
            }
		
    	} catch(Throwable t) {
			System.out.println( t.getMessage());
		}
    }
 
    @Override
    public void destroy() {
         
    }
}