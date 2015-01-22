/**
 * 
 */
package entities;

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
	
	/**
	 * empty constructor
	 */
	public Permission(){
		pid=0;
		cid=0;
		did=0;
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
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}


	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}


	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}


	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}


	/**
	 * @return the did
	 */
	public int getDid() {
		return did;
	}


	/**
	 * @param did the did to set
	 */
	public void setDid(int did) {
		this.did = did;
	}
	
	
	

}
