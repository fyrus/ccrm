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
	
	private String cid;
	private int importance;
	private int interest;
	
	/**
	 * empty constructor
	 */
	public CustomerAttributes(){
		cid="";
		importance=0;
		interest=0;
	}
	
	
	/**
	 * constructor with params
	 * @param cid - the Customer id
	 * @param importance - The importance level of the customer
	 * @param intrest - the interesting level of the customer
	 */
	public CustomerAttributes(String cid,int importance,int intrest){
		this.cid=cid;
		this.importance=importance;
		this.interest=intrest;		
	}


	/**
	 * @return the customer id
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * @param cid the customer id to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * @return the importance level of the customer
	 */
	public int getImportence() {
		return importance;
	}


	/**
	 * @param importence the importance level of the customer to set
	 */
	public void setImportence(int importance) {
		this.importance = importance;
	}


	/**
	 * @return the interest customer level
	 */
	public int getinterest() {
		return interest;
	}


	/**
	 * @param interest the interest customer level to set
	 */
	public void setinterest(int interest) {
		this.interest = interest;
	}
	
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return getCid();
	}
	
	

}
