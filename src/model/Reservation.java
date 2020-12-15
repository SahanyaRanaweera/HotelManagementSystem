package model;

public class Reservation {

	private int id;
	private String guestName;
	private String email;
	private String phone;
	private String nic;
	private String roomType;
	private String AC;
	private int noOfGuests;
	private String arrivalDate;
	private String departureDate;
	private int roomNo;
	private int buildingNo;

	/**
	 * @param id
	 * @param guestName
	 * @param email
	 * @param phone
	 * @param nic
	 * @param roomType
	 * @param aC
	 * @param noOfGuests
	 * @param arrivalDate
	 * @param departureDate
	 * @param roomNo
	 * @param buildingNo
	 */
	public Reservation(int id, String guestName, String email, String phone, String nic, String roomType, String aC,
			int noOfGuests, String arrivalDate, String departureDate, int roomNo, int buildingNo) {
		this.id = id;
		this.guestName = guestName;
		this.email = email;
		this.phone = phone;
		this.nic = nic;
		this.roomType = roomType;
		AC = aC;
		this.noOfGuests = noOfGuests;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.roomNo = roomNo;
		this.buildingNo = buildingNo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the guestName
	 */
	public String getGuestName() {
		return guestName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @return the aC
	 */
	public String getAC() {
		return AC;
	}

	/**
	 * @return the noOfGuests
	 */
	public int getNoOfGuests() {
		return noOfGuests;
	}

	/**
	 * @return the arrivalDate
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @return the departureDate
	 */
	public String getDepartureDate() {
		return departureDate;
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
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * @param nic the nic to set
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param guestName the guestName to set
	 */
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * @param aC the aC to set
	 */
	public void setAC(String aC) {
		AC = aC;
	}

	/**
	 * @param noOfGuests the noOfGuests to set
	 */
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
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

}
