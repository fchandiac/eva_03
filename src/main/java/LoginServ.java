

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.iplacex.app.FindUser;
import com.iplacex.app.Login;

/**
 * Servlet implementation class LoginServ
 */
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_in = request.getParameter("user");
		String pass_in = request.getParameter("pass");
		FindUser find = new FindUser();
		String rut = find.getRutbyUser(user_in);
		
		if (rut.equals("") == true) {
			response.getWriter().append("<html><body>");
			response.getWriter().append("<h1>Usuario no encontrado</h1>");
			response.getWriter().append("</body></html>");
		} else {
			Login log = new Login();
			boolean logResult = log.TryLogin(user_in, pass_in);
			if(logResult == true) {
				String person = find.getPerson(rut);
				response.getWriter().append("<html><body>");
				response.getWriter().append("<h1>Acceso Correcto</h1>");
				response.getWriter().append("<br></br>");
				response.getWriter().append("<h5>"+ person +"</h5>");
				response.getWriter().append("</body></html>");
			} else {
				response.getWriter().append("<html><body>");
				response.getWriter().append("<h1>Contraseña Incorrecta</h1>");
				response.getWriter().append("</body></html>");
			}
			
			
		}
		
		//response.getWriter().append("Served at: " + rut).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
	}

}
