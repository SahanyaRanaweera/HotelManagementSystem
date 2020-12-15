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
 * Servlet implementation class ReportController
 */
@WebServlet("/Report")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> actionMap = new HashMap<String, Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		actionMap.put("View payment report", new PaymentReport());
		actionMap.put("View service list", new ServiceList());
		actionMap.put("View room list", new RoomList());
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

		if (view.equals("payment")) {
			RequestDispatcher dis = request.getRequestDispatcher("paymentReport.jsp");
			dis.forward(request, response);
		}else if (view.equals("service")) {
			RequestDispatcher dis = request.getRequestDispatcher("servicelist.jsp");
			dis.forward(request, response);
		}else if (view.equals("room")) {
			RequestDispatcher dis = request.getRequestDispatcher("roomlist.jsp");
			dis.forward(request, response);
		}
	}

}
