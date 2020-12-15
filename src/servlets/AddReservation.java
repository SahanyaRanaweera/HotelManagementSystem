package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reservation;
import util.ReservationDBUtil;

public class AddReservation implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String name = request.getParameter("gname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String Rtype = request.getParameter("type");
		String AC = request.getParameter("AC");
		String arrivalDate = request.getParameter("arrival");
		String departDate = request.getParameter("departure");
		String nic = request.getParameter("nic");
		boolean success = false;
		try {
			int room = Integer.parseInt(request.getParameter("roomNo"));
			int building = Integer.parseInt(request.getParameter("building"));
			int guests = Integer.parseInt(request.getParameter("guests"));
			success = ReservationDBUtil.insertReservation(name, email, phone, nic, Rtype, AC, guests, arrivalDate,
					departDate, room, building);

			List<Reservation> resList = ReservationDBUtil.getList();
			request.setAttribute("reservation", resList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true)
			return "add";
		else
			return "failure";
	}

}
