package model;

public class Service {
	private String service;
	private double price;
	private int noOfOrders;
	private double cost = 0;
	private String date;

	/**
	 * @param service
	 * @param noOfOrders
	 * @param date
	 */
	public Service(String service, int noOfOrders, String date) {
		this.service = service;
		this.noOfOrders = noOfOrders;
		this.setDate(date);
	}

	/**
	 * @param service
	 * @param noOfOrders
	 * @param date
	 * @param cost
	 */
	public Service(String service, int noOfOrders, String date, double cost) {
		this.setService(service);
		this.noOfOrders = noOfOrders;
		this.setDate(date);
		this.cost = cost;
	}
	

	/**
	 * @param service
	 * @param price
	 */
	public Service(String service, double price) {
		this.service = service;
		this.setPrice(price);
	}

	/**
	 * @return the cost
	 */
	public double getCost(double price) {
		cost = price * noOfOrders;
		return cost;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the noOfOrders
	 */
	public int getNoOfOrders() {
		return noOfOrders;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param noOfOrders the noOfOrders to set
	 */
	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
