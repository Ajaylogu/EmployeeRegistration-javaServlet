
import java.io.IOException;
import java.io.PrintWriter; 
import static java.lang.System.out;
import java.sql.Connection; 

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
@WebServlet("/view")
public class view extends HttpServlet {
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
                           .prepareStatement("select *from user order by Name desc");
            	ResultSet rs=st.executeQuery();
            	
            	out.print("<table border='10' color='blue' width='100%'");
            	out.print("<tr><th>Name</th><th>EmailId</th><th>Password</th><th>Country</th></tr>");
            	while(rs.next()) {
            		out.print("<tr><td>"+((rs.getString(1))+"</td><td>"+rs.getString(2)+"</td><td>"+(rs.getString(3))+"</td><td>"+rs.getString(4)+"</td></tr>"));
            	}
            	out.print("</table>");
        } 
     
        catch (Exception  e) { 
            out.print(e);
        }
	  }    
        finally{
        }
	}
}

