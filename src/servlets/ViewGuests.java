package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guest;
import util.GuestDBUtil;

public class ViewGuests implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		try {
			List<Guest> guest = GuestDBUtil.getGuestList();
			request.setAttribute("guest", guest);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "display";
	}
}
