/**
 * 
 */
package entities;

/**
 * This is the Marketing Manager class 
 * @author Yossi
 *
 */
public class MarketingManager extends MarketingMan {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9018538110110563517L;
	
	/**
	 * empty default constructor
	 */
	public MarketingManager(){
		super();
		setRole("Marketing Manager");
	}
	
	/**
	 * 
	 * @param uid - The Marketing Manager id
	 * @param name- The Marketing Manager name
	 * @param password- The Marketing Manager password
	 * @param address- The Marketing Manager address
	 * @param phone- The Marketing Manager phone
	 */
	public MarketingManager(int uid,String name,String password,String address,String phone){
		super(uid,name,password,address,phone);
		setRole("Marketing Manager");
	}
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return getName();
	}

}
