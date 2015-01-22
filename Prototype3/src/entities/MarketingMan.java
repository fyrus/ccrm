/**
 * 
 */
package entities;

/**
 * This class is the marketing man class 
 * Marketing Man can do the following actions:
 * set Customer Permission
 * set Message To Customer
 * insert Product Details
 * all of the actions above will be in the GUI
 * @author Yossi
 *
 */


public class MarketingMan extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1523235638096253557L;


	/**
	 * empty constructor
	 */
	public MarketingMan(){
		super();
		setRole("Marketing Man");
	}
	
	
	/**
	 * Marketing Man constructor with params:
	 * @param uid
	 * @param name
	 * @param password
	 * @param address
	 * @param phone
	 */
	public MarketingMan(int uid,String name,String password,String address,String phone){
		super(uid,name,password,address,phone);
		setRole("Marketing Man");
	}

		
}
