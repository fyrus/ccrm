/**
 * 
 */
package entities;

/**
 ****WILL NOT BE USED***** 
 * @author Yossi
 * 
 */
public class Employee extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5532931648490751460L;
	String eid;
	String role;
	/**
	 * empty constructor
	 * ***WILL NOT BE USED***** 
	 */
	public Employee(){
		super();
		eid="";
		role="";	
	}
	
	/**
	 * ***WILL NOT BE USED***** 
	 * New employee constructor with:
	 * @param eid is employee id
	 * @param role it the employee role
	 */
	public Employee(String eid,String role){
		super(); //<-----------------------------------this is not right
		this.eid=eid;
		this.role=role;
	}

	/**
	 * @return the eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * @param eid the eid to set
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
