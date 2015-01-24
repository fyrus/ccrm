/**
 * 
 */
package entities;

import java.util.List;

/**
 * This is the permission class
 * @author Yossi
 */
public class Permission implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1460346418085688970L;
	private int pid;
	private int cid;
	private int did;
	private List<Customer> customerList;

	
	/**
	 * empty constructor
	 */
	public Permission(){
		pid=0;
		cid=0;
		did=0;
		this.customerList=null;
	}
	
	
	/**
	 * Constructor with: 
	 * @param pid the permission id
	 * @param cid the customer id
	 * @param did the permission domain
	 */
	public Permission(int pid,int cid,int did){
		this.pid=pid;
		this.cid=cid;
		this.did=did;
	}


	/**
	 * @return the permission id
	 */
	public int getPid() {
		return pid;
	}


	/**
	 * @param pid the permission id to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}


	/**
	 * @return the customer id
	 */
	public int getCid() {
		return cid;
	}


	/**
	 * @param cid the customer id to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}


	/**
	 * @return the permission domain
	 */
	public int getDid() {
		return did;
	}


	/**
	 * @param did the permission domain to set
	 */
	public void setDid(int did) {
		this.did = did;
	}
	
	/**
	 * Override toString method for type name display
	 */
	@Override
	public String toString() {
		return (""+getCid()+getPid()+getDid());
	}

	
	
	

}
