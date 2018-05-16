

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

		protected void doGet(HttpServletRequest request,HttpServletResponse response) 
				throws IOException{
			
		PrintWriter	out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet'href='https://www.w3schools.com/w3css/4/w3.css'>");
		out.println("<title>");
		out.println("STUDENT EVOLUTION");
		out.println("</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<header class='w3-container w3-black'>");
		out.println("<h1>");
		out.println("GAME");
		out.println("</h1>");
		out.println("</header>");
		out.println("</body>");
		out.println("</html>");	
		
			
		}
}
