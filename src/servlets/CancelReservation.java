package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ReservationDBUtil;

public class CancelReservation implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		boolean success = false;
		try {
			String nic = request.getParameter("gnic");
			String date = request.getParameter("adate");
			success = ReservationDBUtil.cancelReservation(nic, date);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true)
			return "cancel";
		else
			return "error";
	}

}
