/**
 * 
 */
package entities;

/**
 * 
 * !!!!!!!!!!!!!!!!!!!!!!
 * 
 * 
 * not used
 * 
 * use sale
 * 
 * 
 * !!!!!!!!!!!!!!!!!!!
 */

/**
 * this is the Customer Purchase Or Rejection class
 * @author YOSSI
 */
public class CustomerPurchaseOrRejection implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9140829761762372199L;
	private String cid;
	private int pid;
	private String pData;
	private String rejectionMsg;
	
	
	/**
	 * empty constructor
	 */
	public CustomerPurchaseOrRejection(){
		cid="";
		pid=0;
		pData="";
		rejectionMsg="";
	}
	
	/**
	 * New CustomerPurchaseOrRejection constructor
	 * @param cid customer id
	 * @param pid purchase id
	 * @param pData purchase date
	 * @param rejectionMsg rejection message in case of non-purchase
	 */
	public CustomerPurchaseOrRejection(String cid,int pid,String pData,String rejectionMsg){
		this.cid=cid;
		this.pid=pid;
		this.pData=pData;
		this.rejectionMsg=rejectionMsg;
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
	 * @return the pData
	 */
	public String getpData() {
		return pData;
	}

	/**
	 * @param pData the pData to set
	 */
	public void setpData(String pData) {
		this.pData = pData;
	}

	/**
	 * @return the rejectionMsg
	 */
	public String getRejectionMsg() {
		return rejectionMsg;
	}

	/**
	 * @param rejectionMsg the rejectionMsg to set
	 */
	public void setRejectionMsg(String rejectionMsg) {
		this.rejectionMsg = rejectionMsg;
	}
	
	
	
	
	

}
