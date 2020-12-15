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
 * Servlet implementation class ReservationController
 */
@WebServlet("/Reservation")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> actionMap = new HashMap<String, Action>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		actionMap.put("Add new reservation", new AddReservation());
		actionMap.put("View Reservations", new ViewReservation());
		actionMap.put("Search rooms", new SearchRoom());
		actionMap.put("Check reservation", new Check());
		actionMap.put("Cancel reservation", new CancelReservation());
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

		if (view.equals("add") || view.equals("display")) {
			RequestDispatcher dis = request.getRequestDispatcher("reservationList.jsp");
			dis.forward(request, response);
		} else if (view.equals("failure")) {
			RequestDispatcher dis = request.getRequestDispatcher("addReservation.jsp");
			session.setAttribute("error", "Reservation not added");
			dis.forward(request, response);
		} else if (view.equals("search")) {
			RequestDispatcher dis = request.getRequestDispatcher("availableRooms.jsp");
			dis.forward(request, response);
		} else if (view.equals("check")) {
			RequestDispatcher dis = request.getRequestDispatcher("reservationList.jsp");
			session.setAttribute("checkin", "yes");
			dis.forward(request, response);
		} else if (view.equals("fail")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Guest has not made any reservations");
			dis.forward(request, response);
		}else if (view.equals("cancel")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Reservation cancelled successfully");
			dis.forward(request, response);
		}else if (view.equals("error")) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Error in cancelling reservation");
			dis.forward(request, response);
		}

	}

}
