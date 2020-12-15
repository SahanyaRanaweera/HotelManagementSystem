package model;

public class Guest {
	private int guestID;
	private String name;
	private String phoneNo;
	private String NIC;
	private int roomNo;
	private int buildingNo;
	private int noOfGuests;
	private int resID;
	private double serviceTotal;
	
	/**
	 * 
	 */
	public Guest() {
		this.serviceTotal = 0;
	}

	/**
	 * @param guestID
	 * @param name
	 * @param phoneNo
	 * @param nIC
	 * @param roomNo
	 * @param buildingNo
	 * @param noOfGuests
	 * @param resID
	 */
	public Guest(int guestID, String name, String phoneNo, String nIC, int roomNo, int buildingNo, int noOfGuests,
			int resID) {
		this.guestID = guestID;
		this.name = name;
		this.phoneNo = phoneNo;
		NIC = nIC;
		this.roomNo = roomNo;
		this.buildingNo = buildingNo;
		this.noOfGuests = noOfGuests;
		this.resID = resID;
	}
	
	/**
	 * @return the guestID
	 */
	public int getGuestID() {
		return guestID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @return the nIC
	 */
	public String getNIC() {
		return NIC;
	}
	/**
	 * @param guestID the guestID to set
	 */
	public void setGuestID(int guestID) {
		this.guestID = guestID;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @param nIC the nIC to set
	 */
	public void setNIC(String nIC) {
		NIC = nIC;
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
	 * @return the noOfGuests
	 */
	public int getNoOfGuests() {
		return noOfGuests;
	}
	/**
	 * @return the resID
	 */
	public int getResID() {
		return resID;
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
	 * @param noOfGuests the noOfGuests to set
	 */
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	/**
	 * @param resID the resID to set
	 */
	public void setResID(int resID) {
		this.resID = resID;
	}

	/**
	 * @return the serviceTotal
	 */
	public double getServiceTotal() {
		return serviceTotal;
	}

	/**
	 * @param serviceTotal the serviceTotal to set
	 */
	public void setServiceTotal(double serviceTotal) {
		this.serviceTotal = serviceTotal;
	}
	
}
