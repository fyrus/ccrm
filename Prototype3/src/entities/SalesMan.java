/**
 * 
 */
package entities;

/**
 * This is the sales man class
 * @author Yossi
 *
 */

public class SalesMan extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8105579274111760213L;

	
	/**
	 * empty constructor
	 */
	public SalesMan(){
		super();
		setRole("SalesMan");
	}
	
	/**
	 * constructor with params:
	 * @param uid the Sale Man id
	 * @param name the Sale Man name
	 * @param password the Sale Man password
	 * @param address the Sale Man address
	 * @param phone the Sale Man phone
	 */
	public SalesMan(int uid,String name,String password,String address,String phone){
		super(uid,name,password,address,phone);
		setRole("SalesMan");
	}
	
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return (getName());
	}


	
}
