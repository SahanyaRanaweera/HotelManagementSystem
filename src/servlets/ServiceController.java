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

/**
 * Servlet implementation class ServiceController
 */
@WebServlet("/Service")
public class ServiceController extends HttpServlet {
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
		try {
			int room = Integer.parseInt(request.getParameter("room"));
			int building = Integer.parseInt(request.getParameter("building"));
			String service = request.getParameter("serviceName");
			int orders = Integer.parseInt(request.getParameter("noOfOrders"));
			String date = request.getParameter("sdate");

			success = GuestDBUtil.addService(room, building, service, orders, date);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true) {
			RequestDispatcher dis = request.getRequestDispatcher("results.jsp");
			session.setAttribute("msg", "Service added successfully");
			dis.forward(request, response);
		}
	}

}
