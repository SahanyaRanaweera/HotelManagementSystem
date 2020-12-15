package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ServiceDBUtil;

public class RoomRate implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		boolean success = false;
		String type = request.getParameter("type");
		double price = Double.parseDouble(request.getParameter("price"));
		double priceac = Double.parseDouble(request.getParameter("priceac"));
		try {
			success = ServiceDBUtil.setRoomrate(type, price, priceac);
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true) {
			return "rate";
		}else {
			return "failure";
		}
	}

}
