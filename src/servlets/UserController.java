package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/User")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private Map<String, Action> actionMap = new HashMap<String, Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		actionMap.put("Add user", new AddUser());
		actionMap.put("View users", new ViewUsers());
		actionMap.put("Delete user", new DeleteUser());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionKey;
		String view = null;
		HttpSession session = request.getSession(false);
		try {
			actionKey = request.getParameter("action");
			Action action = actionMap.get(actionKey);
			view = action.execute(request, response);
			session.setAttribute("error", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (view.equals("user")) {
			RequestDispatcher dis = request.getRequestDispatcher("userlist.jsp");
			dis.forward(request, response);
		}else if (view.equals("error")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Error in adding new user");
			dis.forward(request, response);
		}else if (view.equals("adduser")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "User added successfully");
			dis.forward(request, response);
		}
		else if (view.equals("fail")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Error in removing user");
			dis.forward(request, response);
		}else if (view.equals("removeuser")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "User removed successfully");
			dis.forward(request, response);
		}
	}

}
