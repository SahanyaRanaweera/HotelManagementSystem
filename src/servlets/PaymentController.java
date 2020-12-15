package servlets;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.GuestDBUtil;
import util.PaymentDBUtil;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/Payment")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		boolean success = false;
		String method = request.getParameter("paymethod");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String date = request.getParameter("date");
		int room = Integer.parseInt(request.getParameter("room"));
		int building = Integer.parseInt(request.getParameter("building"));
		int guestid = 0;
		try {
			guestid = GuestDBUtil.getGuestid(room, building);
			success = PaymentDBUtil.addPayment(method, amount, date, room, building, guestid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true) {
			session.setAttribute("msg", "Payment added successfully");
		} else {
			session.setAttribute("msg", "Error in adding payment");
		}
		RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
		dis.forward(request, response);
	}

}
