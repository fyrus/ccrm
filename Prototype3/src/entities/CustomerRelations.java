/**
 * 
 */
package entities;

import java.sql.Date;

/**
 * This class is the customer relations class
 * @author Yossi
 * 
 */
public class CustomerRelations extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5455391236987260453L;

	/**
	 * Default empty constructor
	 */
	public CustomerRelations(){
		super();
		this.setRole("CustomerRelations");
	}
	
	/**
	 * New Customer Relations constructor
	 * @param uid user id
	 * @param name user name
	 * @param password use password
	 * @param address user address
	 * @param phone user phone
	 */
	public CustomerRelations(int uid,String name,String password,String address,String phone){
		super(uid,name,password,address,phone);
		this.setRole("CustomerRelations");
	}

	/**
	 * PROBOBLY WILL BE DELETED
	 * this method will return Customer type
	 * need to be changed in the class diagram
	 */
	Customer setPotentialCustomerDetails(String cid,String cname,Date cbd ,String clocation ,String cphone){
		// set customer details
		Customer cust = new Customer(cid,cname,cbd , clocation ,cphone);
		return cust;
     } 

	
	

}
