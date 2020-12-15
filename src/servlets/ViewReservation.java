package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reservation;
import util.ReservationDBUtil;

public class ViewReservation implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		try {
			List<Reservation> resList = ReservationDBUtil.getList();
			request.setAttribute("reservation", resList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "display";
	}

}
