package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import util.UserDBUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/log")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get parameters username and password
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String utype = null;
		HttpSession session = request.getSession();

		try {
			// call validateLogin method in UserDBUtil
			List<User> userDetails = UserDBUtil.validateLogin(username, password);
			if(userDetails != null) {
				for (User u1 : userDetails) {
					utype = u1.getType();
				}
			}
			
			request.setAttribute("userDetails", userDetails);
			session.setAttribute("user", username);
			session.setAttribute("error", " ");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// redirect to user account page
		if (request.getAttribute("userDetails") == null) {
			RequestDispatcher reqDispatch = request.getRequestDispatcher("login.jsp");
			session.setAttribute("error", "Invalid login");
			reqDispatch.forward(request, response);
		} else {
			RequestDispatcher reqDispatch = request.getRequestDispatcher("dashboard.jsp");
			if (utype.equals("R")) {
				session.setAttribute("title", "Receptionist");
			} else if (utype.equals("M")) {
				session.setAttribute("title", "Manager");
			} else if (utype.equals("O")) {
				session.setAttribute("title", "Owner");
			}else {
				session.setAttribute("title", " ");
			}
			reqDispatch.forward(request, response);
		}
		
	}

}
