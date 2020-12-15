package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guest;
import model.Reservation;
import util.GuestDBUtil;
import util.ReservationDBUtil;

public class AddGuest implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
			List<Reservation> resList = null;
			boolean success = false;
			String name = null;
			String email = null;
			String phone = null;
			int roomNo = 0;
			int buildingNo = 0;
			int guests = 0;
			int resId = 0;
			String departure = null;
			String arrival = null;

			try {

				String nic = request.getParameter("gnic");
				String date = request.getParameter("adate");
				resList = ReservationDBUtil.checkGuest(nic, date);
				for (Reservation r : resList) {
					name = r.getGuestName();
					email = r.getEmail();
					phone = r.getPhone();
					roomNo = r.getRoomNo();
					buildingNo = r.getBuildingNo();
					guests = r.getNoOfGuests();
					resId = r.getId();
					departure = r.getDepartureDate();
					arrival = r.getArrivalDate();
				}
				success = GuestDBUtil.insertGuest(name, email, phone, nic, resId, roomNo, buildingNo, guests, departure,
						arrival);
			List<Guest> guest = GuestDBUtil.getGuestList();
			request.setAttribute("guest", guest);
		} catch (Exception e) {
			e.printStackTrace();
		}

			if (success == true)
				return "add";
			else
				return "failure";
	}
	
}
