/**
 * 
 */
package entities;

/**
 * This class will define Customer attribute.
 * @author Yossi
 *
 */
public class CustomerAttributes implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8722679810771117532L;
	
	private String customerid;
	private int importance;
	private int interest;
	
	/**
	 * empty constructor
	 */
	public CustomerAttributes(){
		customerid="";
		importance=0;
		interest=0;
	}
	
	
	/**
	 * constructor with params
	 * @param customerid - the Customer id
	 * @param importance - The importance level of the customer
	 * @param intrest - the interesting level of the customer
	 */
	public CustomerAttributes(String customerid,int importance,int intrest){
		this.customerid=customerid;
		this.importance=importance;
		this.interest=intrest;		
	}


	/**
	 * @return the customer id
	 */
	public String getCustomerid() {
		return customerid;
	}


	/**
	 * @param customerid the customer id to set
	 */
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}


	/**
	 * @return the importance level of the customer
	 */
	public int getImportance() {
		return importance;
	}


	/**
	 * @param importence the importance level of the customer to set
	 */
	public void setImportance(int importance) {
		this.importance = importance;
	}


	/**
	 * @return the interest customer level
	 */
	public int getInterest() {
		return interest;
	}


	/**
	 * @param interest the interest customer level to set
	 */
	public void setInterest(int interest) {
		this.interest = interest;
	}
	
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return getCustomerid();
	}
	
	

}
