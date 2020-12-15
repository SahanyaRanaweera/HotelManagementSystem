package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bill;
import model.Guest;
import model.Service;
import util.GuestDBUtil;
import util.ReservationDBUtil;

/**
 * Servlet implementation class CheckoutController
 */
@WebServlet("/Checkout")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Bill bill = new Bill();
		double total = 0;
		try {
			int room = Integer.parseInt(request.getParameter("room"));
			int building = Integer.parseInt(request.getParameter("building"));
			String date = request.getParameter("cdate");
			total = ReservationDBUtil.getRoomCost(room, building, bill, date);
			bill.setRoomCost(total);

			Guest g = bill.getGuest();

			List<Service> list = GuestDBUtil.getServiceList(room, building, g);

			bill.setTotalCost();

			request.setAttribute("services", list);
			bill.setServices(list);
			request.setAttribute("room", room);
			request.setAttribute("building", building);
			request.setAttribute("roomType", bill.getRoomType());
			request.setAttribute("ac", bill.getAc());
			request.setAttribute("roomCost", total);
			request.setAttribute("serviceCost", g.getServiceTotal());
			request.setAttribute("totalCost", bill.getTotalCost());

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("serviceBill.jsp");
		dis.forward(request, response);
	}

}
