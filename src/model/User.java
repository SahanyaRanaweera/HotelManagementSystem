package model;

public class User {
	private int userID;
	private String name;
	private String address;
	private String email;
	private String phoneNo;
	private String NIC;
	private String username;
	private String password;
	private String type;

	/**
	 * @param userID
	 * @param name
	 * @param address
	 * @param email
	 * @param phoneNo
	 * @param nIC
	 * @param username
	 * @param password
	 * @param type
	 */
	public User(int userID, String name, String address, String email, String phoneNo, String nIC, String username,
			String password, String type) {
		this.userID = userID;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNo = phoneNo;
		NIC = nIC;
		this.username = username;
		this.password = password;
		this.type = type;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
