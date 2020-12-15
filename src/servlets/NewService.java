package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import util.ServiceDBUtil;

public class NewService implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String service = request.getParameter("sname");
		double price = Double.parseDouble(request.getParameter("price"));
		boolean success = false;
		try {
			success = ServiceDBUtil.addNewService(service, price);
			List<Service> slist = ServiceDBUtil.getServicelist();
			request.setAttribute("servicelist", slist);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (success == true) {
			return "addservice";
		}else {
			return "error";
		}
	}

}
