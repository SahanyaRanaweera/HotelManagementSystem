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
 * Servlet implementation class ManagementController
 */
@WebServlet("/Management")
public class ManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> actionMap = new HashMap<String, Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		actionMap.put("Add new Service", new NewService());
		actionMap.put("Add new Room", new NewRoom());
		actionMap.put("Set room rate", new RoomRate());
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

		if (view.equals("addservice")) {
			RequestDispatcher dis = request.getRequestDispatcher("servicelist.jsp");
			dis.forward(request, response);
		}else if (view.equals("error")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Error in adding new service");
			dis.forward(request, response);
		}else if (view.equals("addroom")) {
			RequestDispatcher dis = request.getRequestDispatcher("roomlist.jsp");
			dis.forward(request, response);
		}else if (view.equals("fail")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Error in adding new room");
			dis.forward(request, response);
		}else if (view.equals("rate")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Room rates changed successfully");
			dis.forward(request, response);
		}else if (view.equals("failure")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Error in updating room rates");
			dis.forward(request, response);
		}
	}

}
