package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Room;
import model.Service;

public class ServiceDBUtil {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet res = null;
	
	public static List<Service> getServicelist(){
		ArrayList<Service> servicelist = new ArrayList<>();
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "select * from service";
			res = stmt.executeQuery(sql);
			while (res.next()) {
				String service = res.getString(2);
				double price = res.getDouble(3);
				Service s1 = new Service(service, price);
				servicelist.add(s1);
			}
			res.close();
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return servicelist;
	}
	
	public static boolean addNewService(String service, double price) {
		boolean success = false;
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "insert into service values (0, '"+service+"', '"+price+"')";
			int r = stmt.executeUpdate(sql);
			if (r > 0) {
				success = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public static List<Room> getRoomlist(){
		ArrayList<Room> roomlist = new ArrayList<>();
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "select * from room ";
			res = stmt.executeQuery(sql);
			while (res.next()) {
				int room = res.getInt(1);
				int building = res.getInt(2);
				int floor = res.getInt(3);
				int typeid = res.getInt(4);
				String status = res.getString(5);
				String ac = res.getString(6);
				Room r1 = new Room(room, building, floor, typeid, status, ac);
				roomlist.add(r1);
			}
			res.close();
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return roomlist;
	}
	public static boolean addNewRoom(int room, int building, int floor, int type, String status, String ac) {
		boolean success = false;
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "insert into room values ('"+room+"', '"+building+"', '"+floor+"', '"+type+"', '"+status+"', '"+ac+"')";
			int r = stmt.executeUpdate(sql);
			if (r > 0) {
				success = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public static boolean setRoomrate(String type, double price, double priceac) {
		boolean success =false;
		try {
			conn = DBConnect.connect();
			stmt = conn.createStatement();
			String sql = "update roomtype set price = '"+price+"', priceforAC = '"+priceac+"' where name = '"+type+"'";
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
