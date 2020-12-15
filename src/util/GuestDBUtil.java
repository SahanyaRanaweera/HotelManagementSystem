package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Guest;
import model.Service;

public class GuestDBUtil {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet res = null;

	public static boolean insertGuest(String name, String email, String phone, String nic, int resid, int room,
			int building, int guests, String departure, String arrival) {
		boolean success = false;

		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "insert into guest values (0, '" + name + "', '" + nic + "', '" + phone + "', '" + room
					+ "', '" + building + "', '" + guests + "', '" + resid + "', '" + departure + "', '" + arrival
					+ "')";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
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

	public static List<Guest> getGuestList() {

		ArrayList<Guest> guestList = new ArrayList<>();

		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM hotel.guest where roomNo <> 0 and buildingNo <> 0";
			res = stmt.executeQuery(sql);

			while (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String nic = res.getString(3);
				String phone = res.getString(4);
				int room = res.getInt(5);
				int building = res.getInt(6);
				int guests = res.getInt(7);
				int resId = res.getInt(8);
				Guest guest1 = new Guest(id, name, phone, nic, room, building, guests, resId);
				guestList.add(guest1);
			}
			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return guestList;

	}

	public static boolean addService(int room, int building, String service, int orders, String date) {
		boolean success = false;

		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "select * from service where serviceName = '" + service + "'";
			res = stmt.executeQuery(sql);
			int code = 0;
			double price = 0;
			Service s1 = new Service(service, orders, date);
			if (res.next()) {
				code = res.getInt(1);
				price = res.getDouble(3);
			}
			double cost = s1.getCost(price);
			sql = "insert into guest_service values (0, '" + room + "', '" + code + "', '" + orders + "', '" + cost
					+ "', '" + date + "', '" + building + "')";
			int r = stmt.executeUpdate(sql);

			if (r > 0) {
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

	public static List<Service> getServiceList(int room, int building, Guest g) {
		double total = 0;
		ArrayList<Service> services = new ArrayList<>();
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "select * from guestservicelist where roomNo = '" + room + "' and building = '" + building
					+ "'";
			res = stmt.executeQuery(sql);

			while (res.next()) {
				String service = res.getString(7);
				int noOfOrders = res.getInt(3);
				double cost = res.getDouble(4);
				String date = res.getString(5);
				total = total + cost;
				Service s = new Service(service, noOfOrders, date, cost);
				services.add(s);
			}
			res.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		g.setServiceTotal(total);
		return services;
	}

	public static int getGuestid(int room, int building) {
		int guestid = 0;
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "select guestId from guest where roomNo = '" + room + "' and buildingNo = '" + building + "'";
			res = stmt.executeQuery(sql);

			if (res.next()) {
				guestid = res.getInt(1);
			}
			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return guestid;
	}

	public static boolean removeGuest(int guestid) {
		boolean success = false;
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "delete from guest where guestId = '"+guestid+"'";
			int r = stmt.executeUpdate(sql);
			if (r > 0) {
				success = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}
}
