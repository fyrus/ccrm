/**
 * 
 */
package entities;

/**
 * This class is the marketing man class 
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
	 * @param uid the Marketing Man id
	 * @param name - the Marketing Man name
	 * @param password - the Marketing Man password
	 * @param address - the Marketing Man address
	 * @param phone - the Marketing Man phone
	 */
	public MarketingMan(int uid,String name,String password,String address,String phone){
		super(uid,name,password,address,phone);
		setRole("Marketing Man");	
	}
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return getName();
	}

		
}
