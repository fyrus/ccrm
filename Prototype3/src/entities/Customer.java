package entities;

import java.sql.Date;

/**
 * A class with all customer details
 * @author Dima
 *
 */
public class Customer implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7750541670568873020L;
	//customer ID
	private String cId;
	//customer name
	private String cName;
	//customer birth date
	private Date cBirthDate;
	//customer address location
	private String cLocation;
	// customers phone number
	private String cPhone;
	//list of permits for client
	
	
	/**
	 * Default constructor - blank customer
	 */
	public Customer(){
		cId="";
		cName="";
		cBirthDate=new Date(0);
		cLocation="";
		cPhone="";
		
	}
	/**
	 * New customer constructor
	 * @param id customer id
	 * @param name customer name
	 * @param bd customer birth date
	 * @param loc customer location
	 * @param phone customer phone
	 */
	public Customer(String id,String name,Date bd,String loc,String phone){
		cId=id;
		cName=name;
		cBirthDate=bd;
		cLocation=loc;
		cPhone=phone;
		
	}
	/**
	 * @return the customer id
	 */
	public String getcId() {
		return cId;
	}
	/**
	 * @param cid the customer id to set
	 */
	public void setcId(String cid) {
		this.cId = cid;
	}
	/**
	 * @return the customer name
	 */
	public String getcName() {
		return cName;
	}
	/**
	 * @param cname the customer name to set
	 */
	public void setcName(String cname) {
		this.cName = cname;
	}
	/**
	 * @return the customer birth date
	 */
	public Date getcBirthDate() {
		return cBirthDate;
	}
	/**
	 * @param cBirthDate the customer birth date to set
	 */
	public void setcBirthDate(Date cBirthDate) {
		this.cBirthDate = cBirthDate;
	}
	/**
	 * @return the customer location
	 */
	public String getcLocation() {
		return cLocation;
	}
	/**
	 * @param cLocation the customer location to set
	 */
	public void setcLocation(String cLocation) {
		this.cLocation = cLocation;
	}
	/**
	 * @return the customer phone
	 */
	public String getcPhone() {
		return cPhone;
	}
	/**
	 * @param cPhone the customer phone to set
	 */
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	

}
