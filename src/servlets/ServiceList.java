package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import util.ServiceDBUtil;

public class ServiceList implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			List<Service> slist = ServiceDBUtil.getServicelist();
			request.setAttribute("servicelist", slist);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "service";
	}

}
