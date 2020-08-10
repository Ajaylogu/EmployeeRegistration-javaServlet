import java.io.IOException;
import java.io.PrintWriter; 
import static java.lang.System.out;
import java.sql.Connection; 

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
@WebServlet("/process")
public class process extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try { 
            PrintWriter out = response.getWriter(); 
            String dbURL = "jdbc:mysql://127.0.0.1:3306/"; 
           String dbName = "mysql"; 
           String dbUsername = "root"; 
           String dbPassword = "root"; 
            try { 
            	
            	  Connection con = DriverManager.getConnection(dbURL + dbName, 
                        dbUsername,
                        dbPassword);
                    PreparedStatement st = con
                           .prepareStatement("insert into user values(?,?,?,?,?)");
                st.setString(1,(request.getParameter("usrnm")));
                
                st.setString(2, (request.getParameter("eml")));
                st.setString(3, (request.getParameter("psw")));
                st.setString(4, (request.getParameter("cry")));
                st.setInt(5, Integer.valueOf((request.getParameter("mo"))));
            	st.executeUpdate();
            	RequestDispatcher rd=request.getRequestDispatcher("view");
            	rd.forward(request, response);
            	
        } 
     
        catch (Exception  e) { 
            out.print(e);
        }
	  }    
        finally{
        }
	}
}