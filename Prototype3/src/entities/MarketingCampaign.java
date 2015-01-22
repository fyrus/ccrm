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
	private String cdate;
	private ArrayList<Customer> cust;
	
	
	/**
	 * empty constructor
	 */
	public MarketingCampaign(){
		cid=0;
		cdate="";
		cust=new ArrayList<Customer>();
	}
	
	
	/**
	 * constructor with params:
	 * @param cmpid
	 * @param cdate
	 */
	public MarketingCampaign(int cid, String cdate){
		this.cid=cid;
		this.cdate=cdate;
		cust=null;
	}
	
	/**
	 * If the new campaign have this information.
	 * @param cmpid
	 * @param cdate
	 * @param cust
	 */
	public MarketingCampaign(int cid,String cdate,ArrayList<Customer> cust){
		this.cid=cid;
		this.cdate=cdate;
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
	 * @return the cdate
	 */
	public String getCdate() {
		return cdate;
	}


	/**
	 * @param cdate the cdate to set
	 */
	public void setCdate(String cdate) {
		this.cdate = cdate;
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
