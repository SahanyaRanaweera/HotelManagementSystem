package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Room;
import util.ReservationDBUtil;

public class SearchRoom implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		try {
			String typeR = request.getParameter("type");
			String ac = request.getParameter("ac");
			List<Room> roomList = ReservationDBUtil.checkAvailability(typeR, ac);
			request.setAttribute("rooms", roomList);
			request.setAttribute("type", typeR);
			request.setAttribute("ac", ac);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "search";
	}
}
