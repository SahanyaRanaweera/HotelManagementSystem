package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Room;
import util.ServiceDBUtil;

public class RoomList implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			List<Room> rlist = ServiceDBUtil.getRoomlist();
			request.setAttribute("roomlist", rlist);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "room";
	}
}
