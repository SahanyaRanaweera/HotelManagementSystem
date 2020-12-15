package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UserDBUtil;

public class DeleteUser implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		boolean success = false;
		String username = request.getParameter("uname");
		try {
			success = UserDBUtil.deleteUser(username);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (success ==true) {
		return "removeuser";
		}else {
			return "fail";
		}
	}

}
