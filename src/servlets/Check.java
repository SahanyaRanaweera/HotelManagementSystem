package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reservation;
import util.ReservationDBUtil;

public class Check implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Reservation> resList = null;
		try {
			String nic = request.getParameter("gnic");
			String date = request.getParameter("date");
			resList = ReservationDBUtil.checkGuest(nic, date);
			request.setAttribute("reservation", resList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!resList.isEmpty())
			return "check";
		else
			return "fail";
	}

}
