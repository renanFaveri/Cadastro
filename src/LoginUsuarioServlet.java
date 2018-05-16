

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUsuarioServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		
	PrintWriter	out = response.getWriter();
	
	String login_nome = "";
	
	out.println("<html>");
	out.println("<head>");
	out.println("<link rel='stylesheet'href='https://www.w3schools.com/w3css/4/w3.css'>");
	out.println("<title>");
	out.println("LOGIN");
	out.println("</title>");
	out.println("</head>");
	
	out.println("<body>");
	out.println("<header class='w3-container w3-teal'>");
	out.println("<h1>");
	out.println("Acesso ao Usuário");
	out.println("</h1>");
	out.println("</header>");
	
	out.println("<div class= 'w3-display-middle w3-half w3-margin-top' style='height:500px' >");
	out.println("<form class='w3-container w3-card-4' method='POST' >"); 
	
	out.println("LOGIN ");
	out.println("<input class='w3-input' type='text' name='txtLogin' value='"+login_nome+"' style='width:90%' requered>");
	out.println("<br>");
	
	out.println("SENHA ");
	out.println("<input class='w3-input' type='password' name='txtSenha'style='width:90%' requered>");
	out.println("<br>");
	
	out.println("<input class='w3-button w3-section w3-black w3-ripple' type='submit' value='ENTRAR'>");
	out.println("</form>");
	out.println("</div>");
	
	out.println("</body>");
	out.println("</html>");
	
		
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
		String login = request.getParameter("txtLogin");
		String senha = request.getParameter("txtSenha");
				
		PrintWriter out = response.getWriter();		
		
		try {	
			
			Class.forName("com.mysql.jdbc.Driver");
			String SQL = "SELECT * from tab_jogador WHERE login=? and senha=?";
			
			
			try {
			
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdchallenge","root","");
				PreparedStatement pstm = conn.prepareStatement(SQL); 
			
				pstm.setString(1,login);
				pstm.setString(2,senha);	
				
				ResultSet rs = pstm.executeQuery();
				
				if(rs.next()) {
					pstm.close();
					conn.close();
					
					HttpSession sessao = request.getSession();
					sessao.setAttribute("login", login);
					sessao.setAttribute("senha", senha);			
					
					response.sendRedirect("http://localhost:8080/Senai-challenge/home");
					
				}else {
					
					pstm.close();
					conn.close();
					out.println("Erro");
					
				}		
				
				
			
				
				
			} catch (SQLException e) {
				
				out.println("Erro de Conexão o Banco de Dados");
			} 
			
		
		} catch (ClassNotFoundException ex) {			
			out.println("Erro de Conexão com Driver");
		}		
		
	}
	
}
