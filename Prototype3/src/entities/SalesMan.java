/**
 * 
 */
package entities;

/**
 * This is the sales man class
 * @author Yossi
 *
 */

/*
 * missions to do : 
 * getCustomerListForSales
 * sellProduct(pid : int)
 * +setSCustomerContactEvent(cid : int, eDate Date, pid : int) : boolean
 * +setFCustomerContactEvent(cid : int, pDate : Date, refuseMsg : string)
 * +addMarketingPermission(cid : int, domain : string)
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
	 * @param uid
	 * @param name
	 * @param password
	 * @param address
	 * @param phone
	 */
	public SalesMan(String uid,String name,String password,String address,String phone){
		super(uid,name,password,address,phone);
		setRole("SalesMan");
	}
	
}
