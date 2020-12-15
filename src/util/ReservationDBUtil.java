package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Bill;
import model.Reservation;
import model.Room;

public class ReservationDBUtil {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet res = null;
	private static PreparedStatement pst = null;

	public static boolean insertReservation(String name, String email, String phone, String nic, String type, String ac,
			int guests, String arrival, String departure, int roomNo, int building) {
		boolean success = false;

		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "insert into reservation values (0, '" + name + "', '" + email + "', '" + phone + "', '" + type
					+ "', '" + ac + "', '" + guests + "', '" + arrival + "', '" + departure + "', '" + roomNo + "', '"
					+ building + "', '" + nic + "')";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				success = true;
			} else {
				success = false;
			}
			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

	public static List<Room> checkAvailability(String type, String acStatus) {

		ArrayList<Room> roomList = new ArrayList<>();

		try {
			conn = DBConnect.connect();
			pst = conn.prepareStatement("select * from roomandtype where status = 'Available' and name = ? and ac = ?");
			pst.setString(1, type);
			pst.setString(2, acStatus);
			res = pst.executeQuery();

			while (res.next()) {
				int roomNo = res.getInt(1);
				int building = res.getInt(2);
				String status = res.getString(3);
				String ac = res.getString(4);
				String typeR = res.getString(5);
				double price = res.getDouble(6);
				double priceAc = res.getDouble(7);
				Room r = new Room(roomNo, building, typeR, price, priceAc, status, ac);
				roomList.add(r);
			}
			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return roomList;
	}

	public static List<Reservation> getList() {

		ArrayList<Reservation> resList = new ArrayList<>();

		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "select * from reservation";
			res = stmt.executeQuery(sql);

			while (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String email = res.getString(3);
				String phone = res.getString(4);
				String Rtype = res.getString(5);
				String AC = res.getString(6);
				int guests = res.getInt(7);
				String arrivalDate = res.getString(8);
				String departDate = res.getString(9);
				int room = res.getInt(10);
				int building = res.getInt(11);
				String nic = res.getString(12);
				Reservation reservation1 = new Reservation(id, name, email, phone, nic, Rtype, AC, guests, arrivalDate,
						departDate, room, building);
				resList.add(reservation1);
			}
			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resList;

	}

	public static List<Reservation> checkGuest(String gNic, String adate) {

		ArrayList<Reservation> resList = new ArrayList<>();
		try {

			// create database connection
			conn = DBConnect.connect();
			// executing query to validate user
			stmt = conn.createStatement();
			String sql = "select * from reservation where nic='" + gNic + "' and arrivalDate ='" + adate + "'";
			res = stmt.executeQuery(sql);
			// creating user object with retrieved data
			if (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String email = res.getString(3);
				String phone = res.getString(4);
				String Rtype = res.getString(5);
				String AC = res.getString(6);
				int guests = res.getInt(7);
				String arrivalDate = res.getString(8);
				String departDate = res.getString(9);
				int room = res.getInt(10);
				int building = res.getInt(11);
				String nic = res.getString(12);
				Reservation reservation1 = new Reservation(id, name, email, phone, nic, Rtype, AC, guests, arrivalDate,
						departDate, room, building);
				resList.add(reservation1);
			}
			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// closing
		}

		return resList;
	}
	
	public static boolean cancelReservation(String gNic, String adate) {
		boolean success = false;
		try {
			// create database connection
			conn = DBConnect.connect();
			// executing query to validate user
			stmt = conn.createStatement();
			String sql = "delete from reservation where nic='" + gNic + "' and arrivalDate ='" + adate + "'";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				success = true;
			} else {
				success = false;
			}
			res.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}	

	public static double getRoomCost(int room, int building, Bill b, String date) {
		double price = 0;
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "select * from roomandtype where roomNo = '" + room + "' and buildingNo = '" + building + "'";
			res = stmt.executeQuery(sql);

			int days = 0;
			double priceAc = 0;
			String ac = null;
			String name = null;
			if (res.next()) {
				ac = res.getString(4);
				name = res.getString(5);
				price = res.getDouble(6);
				priceAc = res.getDouble(7);
			}
			if (ac.equals("AC")) {
				price = price + priceAc;
			}
			b.setAc(ac);
			b.setRoomType(name);
			b.setRoom(room);
			b.setBuilding(building);
			days = PaymentDBUtil.getNoOfDays(room, building, date);
			if (days > 0) {
				price = price * days;
			}
			res.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return price;
	}
}
