package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UserDBUtil;

public class AddUser implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		boolean success = false;
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String nic = request.getParameter("nic");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String type = request.getParameter("type");
		try {
			success = UserDBUtil.addUser(name, address, email, phone, nic, uname, pwd, type);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true) {
		return "adduser";
		}else {
			return "error";
		}
	}

}
