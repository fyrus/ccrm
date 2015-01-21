package entities;

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
	private String cid;
	//customer name
	private String cname;
	//customer birth date
	private String cBirthDate;
	//customer address location
	private String cLocation;
	// customers phone number
	private String cPhone;
	//list of permits for client
	
	
	/**
	 * Default constructor - blank customer
	 */
	public Customer(){
		cid="";
		cname="";
		cBirthDate="";
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
	public Customer(String id,String name,String bd,String loc,String phone){
		cid=id;
		cname=name;
		cBirthDate=bd;
		cLocation=loc;
		cPhone=phone;
		
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
	 * @return the customer name
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the customer name to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the customer birth date
	 */
	public String getcBirthDate() {
		return cBirthDate;
	}
	/**
	 * @param cBirthDate the customer birth date to set
	 */
	public void setcBirthDate(String cBirthDate) {
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
