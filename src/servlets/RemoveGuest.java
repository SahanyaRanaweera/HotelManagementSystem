package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GuestDBUtil;

public class RemoveGuest implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		boolean success = false;
		int room = Integer.parseInt(request.getParameter("room"));
		int building = Integer.parseInt(request.getParameter("building"));
		int guestid = 0;
		try {
			guestid = GuestDBUtil.getGuestid(room, building);
			success = GuestDBUtil.removeGuest(guestid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true) {
			return "remove";
		} else {
			return "fail";
		}
			
	}
	
}
