/**
 * 
 */
package entities;

import java.util.*;

/**
 * a registered customer that is in customer database
 * @author Dima
 *
 */
public class RegisteredCustomer extends Customer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2148216109702053679L;
	private List<Permission> permits;
	
	/**
	 * Default constructor - blank registered customer
	 */
	public RegisteredCustomer(){
		super();
		permits=null;
	}
	/**
	 * New registered customer constructor
	 * @param id customer id
	 * @param name customer name
	 * @param bd customer birth date
	 * @param loc customer location
	 * @param phone customer phone
	 */
	public RegisteredCustomer(String id,String name,String bd,String loc,String phone){
		super(id,name,bd,loc,phone);
		permits=new ArrayList<Permission>();
	}
	/**
	 * adds a new permit to customer
	 * @param p permit
	 */
	public void addPermit(Permission p){
		permits.add(p);
	}
	/**
	 * 
	 * @return all permits of the customer
	 */
	public List<Permission> getPermits(){
		return permits;
	}
	/**
	 * Clears all permits from customer
	 */
	public void clearPermits(){
		permits.clear();
	}
	
}
