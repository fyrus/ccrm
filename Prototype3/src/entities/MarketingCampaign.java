/**
 * 
 */
package entities;
import java.util.*;

/**
 * This is the Marketing campaign class
 * @author Yossi
 *
 */

/*
 * 
 * NEW METHOD -
 * void AddCustomer (Customer customer)
 */
public class MarketingCampaign implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3694368127324301985L;
	
	
	private int cid;
	private Date startdate;
	private Date enddate;
	private ArrayList<Customer> cust;
	
	
	/**
	 * empty constructor
	 */
	public MarketingCampaign(){
		cid=0;
		startdate=new Date(0);
		enddate=new Date(0);
		cust=new ArrayList<Customer>();
	}
	
	
	/**
	 * constructor with params:
	 * @param cmpid
	 * @param startdate
	 */
	public MarketingCampaign(int cid, Date startdate, Date enddate){
		this.cid=cid;
		this.startdate=startdate;
		this.enddate=enddate;
		this.cust=new ArrayList<Customer>();
	}
	
	/**
	 * If the new campaign have this information.
	 * @param cmpid
	 * @param startdate
	 * @param cust
	 */
	public MarketingCampaign(int cid, Date startdate, Date enddate,ArrayList<Customer> cust){
		this.cid=cid;
		this.startdate=startdate;
		this.enddate=enddate;
		this.cust=cust;
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
	 * @return the mcid
	 */

	/**
	 * @return the startdate
	 */
	public Date getStartdate() {
		return startdate;
	}


	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
	/**
	 * @return the enddate
	 */
	public Date getEnddate() {
		return enddate;
	}


	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	/**
	 * @return the cust
	 */
	public ArrayList<Customer> getCust() {
		return cust;
	}


	/**
	 * @param cust the cust to set
	 */
	public void setCust(ArrayList<Customer> cust) {
		this.cust = cust;
	}
	
	
	/**
	 * add customer to Array
	 * @param customer
	 */
	public void AddCustomer(Customer customer){
		cust.add(customer);
	}
	

}
