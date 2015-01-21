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
	private String peid;
	private String cid;
	private String peDomain;
	
	/**
	 * empty constructor
	 */
	public Permission(){
		peid="";
		cid="";
		peDomain="";
	}
	
	
	/**
	 * Constructor with: 
	 * @param peid the permission id
	 * @param cid the customer id
	 * @param peDomain the permission domain
	 */
	public Permission(String peid,String cid,String peDomain){
		this.peid=peid;
		this.cid=cid;
		this.peDomain=peDomain;
	}


	/**
	 * @return the peid
	 */
	public String getPeid() {
		return peid;
	}


	/**
	 * @param peid the peid to set
	 */
	public void setPeid(String peid) {
		this.peid = peid;
	}


	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * @return the peDomain
	 */
	public String getPeDomain() {
		return peDomain;
	}


	/**
	 * @param peDomain the peDomain to set
	 */
	public void setPeDomain(String peDomain) {
		this.peDomain = peDomain;
	}
	
	
	

}
