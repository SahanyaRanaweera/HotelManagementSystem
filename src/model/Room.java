package model;

public class Room {

	private int roomNo;
	private int buildingNo;
	private int floorNo;
	private int typeid;
	private String type;
	private double price;
	private double priceAc;
	private String status;
	private String ac;

	/**
	 * @param roomNo
	 * @param buildingNo
	 * @param type
	 * @param price
	 * @param priceAc
	 * @param status
	 * @param ac
	 */
	public Room(int roomNo, int buildingNo, String type, double price, double priceAc, String status, String ac) {
		this.roomNo = roomNo;
		this.buildingNo = buildingNo;
		this.type = type;
		this.price = price;
		this.priceAc = priceAc;
		this.status = status;
		this.ac = ac;
	}
	

	/**
	 * @param roomNo
	 * @param buildingNo
	 * @param floorNo
	 * @param typeid
	 * @param status
	 * @param ac
	 */
	public Room(int roomNo, int buildingNo, int floorNo, int typeid, String status, String ac) {
		this.roomNo = roomNo;
		this.buildingNo = buildingNo;
		this.setFloorNo(floorNo);
		this.setTypeid(typeid);
		this.status = status;
		this.ac = ac;
	}


	/**
	 * @return the roomNo
	 */
	public int getRoomNo() {
		return roomNo;
	}

	/**
	 * @return the buildingNo
	 */
	public int getBuildingNo() {
		return buildingNo;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the priceAc
	 */
	public double getPriceAc() {
		return priceAc;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the ac
	 */
	public String getAc() {
		return ac;
	}

	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	/**
	 * @param buildingNo the buildingNo to set
	 */
	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @param priceAc the priceAc to set
	 */
	public void setPriceAc(double priceAc) {
		this.priceAc = priceAc;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param ac the ac to set
	 */
	public void setAc(String ac) {
		this.ac = ac;
	}


	/**
	 * @return the floorNo
	 */
	public int getFloorNo() {
		return floorNo;
	}


	/**
	 * @param floorNo the floorNo to set
	 */
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}


	/**
	 * @return the typeid
	 */
	public int getTypeid() {
		return typeid;
	}


	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

}
