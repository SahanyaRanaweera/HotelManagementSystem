package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Payment;

public class PaymentDBUtil {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet res = null;

	public static int getNoOfDays(int room, int building, String date) {

		String arrival = null;
		int days = 0;
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "select arrival from guest where roomNo = '" + room + "' and buildingNo = '" + building + "'";
			res = stmt.executeQuery(sql);

			if (res.next()) {
				arrival = res.getString(1);
			}
			sql = "select datediff('" + date + "', '" + arrival + "')";
			res = stmt.executeQuery(sql);

			if (res.next()) {
				days = res.getInt(1);
			}
			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return days;
	}
	
	public static boolean addPayment(String method, double amount, String date, int room, int building, int guest) {
		boolean success = false;
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "insert into payment values (0, '" + amount + "', '" + method + "', '" + date + "', '" + guest
					+ "', '" + room + "', '" + building + "')";
			int r = stmt.executeUpdate(sql);

			String status = "Available";
			sql = "update room set status = '" + status + "' where roomNo = '" + room + "' and buildingNo = '"
					+ building + "'";
			int s = stmt.executeUpdate(sql);

			if (r > 0 && s > 0) {
				success = true;
			}

			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
	
	public static List<Payment> getPaymentList(String startdate, String enddate) {
		ArrayList<Payment> payments = new ArrayList<>();
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "select * from payment where date between cast('" + startdate + "' as date) and cast('"
					+ enddate + "' as date)";
			res = stmt.executeQuery(sql);
			while (res.next()) {
				double amount = res.getDouble(2);
				String method = res.getString(3);
				String date = res.getString(4);
				Payment p = new Payment(method, amount, date);
				payments.add(p);
			}

			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payments;
	}
}
