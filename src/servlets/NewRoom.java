package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Room;
import util.ServiceDBUtil;

public class NewRoom implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int room = Integer.parseInt(request.getParameter("room"));
		int building = Integer.parseInt(request.getParameter("building"));
		int floor = Integer.parseInt(request.getParameter("floor"));
		int type = Integer.parseInt(request.getParameter("type"));
		String status = request.getParameter("status");
		String ac = request.getParameter("ac");
		boolean success = false;
		try {
			success = ServiceDBUtil.addNewRoom(room, building, floor, type, status, ac);
			List<Room> rlist = ServiceDBUtil.getRoomlist();
			request.setAttribute("roomlist", rlist);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true) {
			return "addroom";
		}else {
			return "fail";
		}
		
		
	}

}
