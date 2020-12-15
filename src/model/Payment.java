package model;

public class Payment {

	private String paidMethod;
	private double amount;
	private String date;
	/**
	 * @param paidMethod
	 * @param amount
	 * @param date
	 */
	public Payment(String paidMethod, double amount, String date) {
		this.paidMethod = paidMethod;
		this.amount = amount;
		this.date = date;
	}
	/**
	 * @return the paidMethod
	 */
	public String getPaidMethod() {
		return paidMethod;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param paidMethod the paidMethod to set
	 */
	public void setPaidMethod(String paidMethod) {
		this.paidMethod = paidMethod;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
}
