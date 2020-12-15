package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import util.UserDBUtil;

public class ViewUsers implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<User> userlist = UserDBUtil.getUserlist();
			request.setAttribute("userlist", userlist);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "user";
	}
}
