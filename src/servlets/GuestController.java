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
 * Servlet implementation class GuestController
 */
@WebServlet("/Guest")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> actionMap = new HashMap<String, Action>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		actionMap.put("Add new guest", new AddGuest());
		actionMap.put("View guest list", new ViewGuests());
		actionMap.put("Remove guest", new RemoveGuest());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		if (view.equals("add")) {
			RequestDispatcher dis = request.getRequestDispatcher("guestList.jsp");
			session.setAttribute("checkin", "");
			dis.forward(request, response);
		} else if (view.equals("display")){
			RequestDispatcher dis = request.getRequestDispatcher("guestList.jsp");
			session.setAttribute("checkin", "");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			if (view.equals("failure")) {
				session.setAttribute("msg", "Guest not added");
			} else if (view.equals("remove")) {
				session.setAttribute("msg", "Guest removed");
			}else if (view.equals("fail")) {
				session.setAttribute("msg", "Guest not removed");
			}
			dis.forward(request, response);
		} 
	}

}
