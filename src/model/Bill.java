package model;

import java.util.ArrayList;
import java.util.List;

public class Bill {
	private Guest guest = new Guest();
	private ArrayList<Service> services = new ArrayList<>();
	private double roomCost;
	private String roomType;
	private String ac;
	private int room;
	private int building;
	private double totalCost;

	/**
	 * 
	 */
	public Bill() {
		this.roomCost = 0;
		this.roomType = " ";
		this.ac = " ";
		this.room = 0;
		this.building = 0;
		this.totalCost = 0;
	}

	/**
	 * @return the guest
	 */
	public Guest getGuest() {
		return guest;
	}

	/**
	 * @return the roomCost
	 */
	public double getRoomCost() {
		return roomCost;
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @return the ac
	 */
	public String getAc() {
		return ac;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	/**
	 * @param roomCost the roomCost to set
	 */
	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * @param ac the ac to set
	 */
	public void setAc(String ac) {
		this.ac = ac;
	}

	/**
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * @return the building
	 */
	public int getBuilding() {
		return building;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(int room) {
		this.room = room;
	}

	/**
	 * @param building the building to set
	 */
	public void setBuilding(int building) {
		this.building = building;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost() {
		this.totalCost = guest.getServiceTotal() + this.roomCost;
	}

	public void setServices(List<Service> list) {
		for (Service s : list) {
			services.add(s);
		}
	}

	public List<Service> getServices() {
		return services;
	}
}
