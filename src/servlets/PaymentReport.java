package servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Payment;
import util.PaymentDBUtil;

public class PaymentReport implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		try {
			double total = 0;
			List<Payment> paymentList = PaymentDBUtil.getPaymentList(sdate, edate);
			for (Payment p: paymentList) {
				total = total + p.getAmount();
			}
			request.setAttribute("payments", paymentList);
			request.setAttribute("total", total);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "payment";
	}

}
